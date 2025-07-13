package com.idina.languageadventure.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idina.languageadventure.R
import com.idina.languageadventure.game.IdinaGame

class MainActivity : AppCompatActivity() {
    
    private lateinit var game: IdinaGame
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize the game with the current context
        game = IdinaGame(this)
        
        // Set the game view
        setContentView(game.getView())
    }
    
    override fun onResume() {
        super.onResume()
        game.resume()
    }
    
    override fun onPause() {
        super.onPause()
        game.pause()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        game.dispose()
    }
}
