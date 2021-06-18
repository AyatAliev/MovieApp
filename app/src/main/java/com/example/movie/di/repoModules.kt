package com.example.movie.di

import com.example.movie.ui.home.HomeRepository
import com.example.movie.ui.movie_info.MovieInfoRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules : Module = module {
    single { HomeRepository(get()) }
    single { MovieInfoRepository(get()) }
}