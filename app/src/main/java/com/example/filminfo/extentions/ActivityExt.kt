package com.example.filminfo.extentions

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Activity.fetchColor(id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.fetchColor(id: Int): Int {
    return ContextCompat.getColor(this, id)
}
