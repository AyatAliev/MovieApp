package com.example.filminfo

import android.app.Application
import com.example.filminfo.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FilmApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FilmApp)
            modules(koinModules)
        }
    }
}