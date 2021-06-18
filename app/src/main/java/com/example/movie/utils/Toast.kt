package com.example.movie.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

object Toast {

    fun show(context: Context?, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}