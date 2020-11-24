package com.hackathon.artact.di

import com.hackathon.artact.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    // Activity
    viewModel { IntroViewModel() }
    viewModel { LoginViewModel(androidApplication(), get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ArtworkViewModel() }

    // Fragment
    viewModel { HomeViewModel(get()) }
    viewModel { MyInfoViewModel(get(), get(), get(), get()) }
    viewModel { ShopViewModel(get()) }
}