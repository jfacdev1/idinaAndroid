package com.idina.languageadventure.game

/**
 * Implement this on any LibGDX Screen that wants to receive voice-to-text
 * commands coming from the Android layer.
 */
interface VoiceCommandHandler {
    fun onVoiceCommand(command: String)
}
