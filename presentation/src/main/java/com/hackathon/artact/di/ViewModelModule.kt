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

    // Fragment
    viewModel { HomeViewModel(get()) }
    viewModel { MyInfoViewModel(get()) }
    viewModel { ShopViewModel(get()) }
    viewModel { MenuViewModel() }
}