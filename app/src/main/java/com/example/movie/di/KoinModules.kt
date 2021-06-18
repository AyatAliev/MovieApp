package com.example.movie.di

import com.example.movie.data.local.prefModule
import com.example.movie.data.remote.remoteDataSourceModule
import com.example.movie.core.netwrok.networkModule

val koinModules = listOf(
    networkModule,
    remoteDataSourceModule,
    repoModules,
    viewModules,
    prefModule
)