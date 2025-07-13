package com.idina.languageadventure.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class PortugueseScreen(game: IdinaGame) : BaseCityScreen(game, "Portuguese") {
    override fun render(delta: Float) {
        // Portuguese flag colors: green and red with yellow emblem
        val time = (System.currentTimeMillis() / 1000L) % 3
        when (time.toInt()) {
            0 -> Gdx.gl.glClearColor(0.0f, 0.6f, 0.0f, 1f) // green
            1 -> Gdx.gl.glClearColor(0.8f, 0.0f, 0.0f, 1f) // red
            else -> Gdx.gl.glClearColor(0.9f, 0.8f, 0.0f, 1f) // yellow-ish emblem hint
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }
}
