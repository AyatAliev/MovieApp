package com.example.movie.di

import com.example.movie.ui.home.HomeViewModel
import com.example.movie.ui.main.MainViewModel
import com.example.movie.ui.movie_info.MovieInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { MovieInfoViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}