package com.idina.languageadventure.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class EnglishScreen(game: IdinaGame) : BaseCityScreen(game, "English") {
    override fun render(delta: Float) {
        // Union Jack colors cycle: navy, white, red
        val time = (System.currentTimeMillis() / 1000L) % 3
        when (time.toInt()) {
            0 -> Gdx.gl.glClearColor(0.0f, 0.15f, 0.45f, 1f) // navy
            1 -> Gdx.gl.glClearColor(1f, 1f, 1f, 1f)         // white
            else -> Gdx.gl.glClearColor(0.8f, 0.0f, 0.0f, 1f) // red
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)
    }
}
