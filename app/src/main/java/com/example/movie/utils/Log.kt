package com.example.movie.utils

import com.example.movie.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

object Log {
    private const val TAG = "Movie"

    fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    fun d(message: String?, tag: String = TAG) {
        if (BuildConfig.DEBUG) {
            Timber.tag(tag).d(message)
        }
    }

    fun i(message: String?, tag: String = TAG) {
        if (BuildConfig.DEBUG) {
            Timber.tag(tag).i(message)
        }
    }

    fun e(message: String?, tag: String = TAG) {
        if (BuildConfig.DEBUG) {
            Timber.tag(tag).e(message)
        }
    }
}