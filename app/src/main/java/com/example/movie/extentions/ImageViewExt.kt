package com.example.movie.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.movie.BuildConfig.MOVIE_BASE_URL

fun ImageView.loadImage(url: String?) {
    Glide.with(this).load(MOVIE_BASE_URL+url).centerCrop().into(this)
}

