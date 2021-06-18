package com.example.movie.extentions

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.core.content.ContextCompat

fun Context.fetchColor(id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.fetchDrawable(id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Context.fetchDimension(id: Int): Float {
    return this.resources.getDimension(id)
}
