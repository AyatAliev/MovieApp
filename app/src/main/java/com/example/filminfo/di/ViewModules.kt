package com.example.filminfo.di

import com.example.filminfo.ui.home.HomeViewModel
import com.example.filminfo.ui.main.MainViewModel
import com.example.filminfo.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { HomeViewModel(get()) }
}