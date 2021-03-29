package com.example.filminfo.di

import com.example.filminfo.ui.home.HomeRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules : Module = module {
    single { HomeRepository(get()) }
}