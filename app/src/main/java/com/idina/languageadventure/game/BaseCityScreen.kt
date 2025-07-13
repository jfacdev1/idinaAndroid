package com.idina.languageadventure.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20

/**
 * Base implementation of a simple LibGDX [Screen] that clears the screen and can respond to
 * voice commands. Sub-classes only need to specify a `cityName`.
 */
abstract class BaseCityScreen(
    protected val game: IdinaGame,
    private val cityName: String
) : Screen, VoiceCommandHandler {

    override fun show() {
        Gdx.app.log("CityScreen", "Showing $cityName screen")
    }

    override fun render(delta: Float) {
        // Clear with a distinct color so each screen looks slightly different
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {}

    // Default no-op implementation; subclasses can override if needed
    override fun onVoiceCommand(command: String) {
        Gdx.app.log("CityScreen", "Voice command on $cityName: $command")
    }
}
