package com.idina.languageadventure

import android.app.Application
import com.idina.languageadventure.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IdinaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Koin for dependency injection
        startKoin {
            androidContext(this@IdinaApplication)
            modules(appModule)
        }
    }
}
