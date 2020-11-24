package com.hackathon.artact.di

import com.hackathon.artact.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    // Activity
    viewModel { IntroViewModel() }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }

    // Fragment
    viewModel { HomeViewModel() }
    viewModel { MyInfoViewModel() }
    viewModel { ShopViewModel() }
    viewModel { MenuViewModel() }
}