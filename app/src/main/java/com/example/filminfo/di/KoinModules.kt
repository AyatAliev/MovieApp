package com.example.filminfo.di

import com.example.filminfo.data.local.prefModule
import com.example.filminfo.data.remote.remoteDataSourceModule
import com.example.filminfo.core.netwrok.networkModule

val koinModules = listOf(
    networkModule,
    remoteDataSourceModule,
    repoModules,
    viewModules,
    prefModule
)