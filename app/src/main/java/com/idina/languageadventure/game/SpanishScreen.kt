package com.idina.languageadventure.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class SpanishScreen(game: IdinaGame) : BaseCityScreen(game, "Spanish") {
    override fun render(delta: Float) {
        // Spanish flag-inspired colors cycling: red, yellow
        val time = (System.currentTimeMillis() / 1000L) % 2
        if (time.toInt() == 0) {
            Gdx.gl.glClearColor(0.8f, 0.0f, 0.0f, 1f) // red
        } else {
            Gdx.gl.glClearColor(0.9f, 0.8f, 0.0f, 1f) // yellow
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }
}
