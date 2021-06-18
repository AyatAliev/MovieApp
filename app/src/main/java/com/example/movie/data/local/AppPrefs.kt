package com.example.movie.data.local

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefModule = module {
    single { AppPrefs(androidContext()) }
}

class AppPrefs(context: Context) {

}