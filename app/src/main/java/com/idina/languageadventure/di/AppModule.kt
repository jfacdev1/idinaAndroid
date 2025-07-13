package com.idina.languageadventure.di

import com.idina.languageadventure.game.IdinaGame
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    // Game instance
    single { IdinaGame(androidContext()) }
    
    // Add other dependencies here as needed
    // Example:
    // single { VoiceRecognitionService(androidContext()) }
    // single { LanguageRepository() }
}
