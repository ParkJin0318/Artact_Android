package com.hackathon.artact.di

import com.hackathon.artact.usecase.LoginUseCase
import com.hackathon.artact.usecase.RegisterUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
}