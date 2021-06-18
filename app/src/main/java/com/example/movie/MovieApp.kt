package com.example.movie

import android.app.Application
import com.example.movie.di.koinModules
import com.example.movie.utils.Log
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(koinModules)
        }

        Log.init()
    }
}