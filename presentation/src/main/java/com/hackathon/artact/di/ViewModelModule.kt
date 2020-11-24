package com.hackathon.artact.di

import com.hackathon.artact.viewmodel.IntroViewModel
import com.hackathon.artact.viewmodel.LoginViewModel
import com.hackathon.artact.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { IntroViewModel() }
    viewModel { LoginViewModel() }
    viewModel { RegisterViewModel() }
}