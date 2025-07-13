package com.idina.languageadventure.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import java.util.Locale

/**
 * Simple wrapper around Android's SpeechRecognizer API to convert speech to text and notify
 * a listener with the recognised command. Designed to be lifecycle-aware: call [start] in
 * `onResume`, [stop] in `onPause`, and [release] in `onDestroy` of the hosting Activity.
 */
class VoiceRecognizer(
    private val context: Context,
    private val listener: Listener
) {

    interface Listener {
        /** Called when voice input is converted to a text command. */
        fun onVoiceCommand(command: String)
    }

    private var speechRecognizer: SpeechRecognizer? = null

    private val recognitionListener = object : RecognitionListener {
        override fun onReadyForSpeech(params: Bundle?) {}
        override fun onBeginningOfSpeech() {}
        override fun onRmsChanged(rmsdB: Float) {}
        override fun onBufferReceived(buffer: ByteArray?) {}
        override fun onEndOfSpeech() {}
        override fun onPartialResults(partialResults: Bundle?) {}
        override fun onEvent(eventType: Int, params: Bundle?) {}

        override fun onError(error: Int) {
            // You may extend Listener with an error callback if needed.
        }

        override fun onResults(results: Bundle) {
            val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (!matches.isNullOrEmpty()) {
                // We take the top recognised phrase as the command.
                listener.onVoiceCommand(matches[0])
            }
        }
    }

    init {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context).apply {
                setRecognitionListener(recognitionListener)
            }
        } else {
            // Speech recognition not available on this device. You could throw or log.
            speechRecognizer = null
        }
    }

    /** Begin listening for voice input. */
    fun start() {
        val recognizer = speechRecognizer ?: return
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
        }
        recognizer.startListening(intent)
    }

    /** Stop listening but keep the recogniser ready for future starts. */
    fun stop() {
        speechRecognizer?.stopListening()
    }

    /** Release the underlying SpeechRecognizer resources. Should be called from Activity.onDestroy(). */
    fun release() {
        speechRecognizer?.destroy()
        speechRecognizer = null
    }
}
