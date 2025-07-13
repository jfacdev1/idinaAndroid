package com.idina.languageadventure.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class ItalianScreen(game: IdinaGame) : BaseCityScreen(game, "Italian") {

    override fun render(delta: Float) {
        // Italian flag-inspired background (green, white, red stripes)
        val time = (System.currentTimeMillis() / 1000L) % 3
        when (time.toInt()) {
            0 -> Gdx.gl.glClearColor(0.0f, 0.6f, 0.0f, 1f) // green
            1 -> Gdx.gl.glClearColor(1f, 1f, 1f, 1f)     // white
            else -> Gdx.gl.glClearColor(0.8f, 0.0f, 0.0f, 1f) // red
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }
}
