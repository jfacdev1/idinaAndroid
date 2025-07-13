package com.idina.languageadventure.ui

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import androidx.core.app.ActivityCompat
import com.idina.languageadventure.R
import com.idina.languageadventure.game.IdinaGame

class MainActivity : AndroidApplication(), VoiceRecognizer.Listener {
    
    private lateinit var game: IdinaGame
    private lateinit var voiceRecognizer: VoiceRecognizer
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Request audio permission if needed
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 0)
        // Configure LibGDX
        val config = AndroidApplicationConfiguration().apply {
            useImmersiveMode = true
            numSamples = 2
        }
        game = IdinaGame(this)
        initialize(game, config)

        voiceRecognizer = VoiceRecognizer(this, this)
    }
    
    override fun onResume() {
        super.onResume()
        voiceRecognizer.start()
        game.resume()
    }
    
    override fun onPause() {
        super.onPause()
        voiceRecognizer.stop()
        game.pause()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        voiceRecognizer.release()
        game.dispose()
    }
}
