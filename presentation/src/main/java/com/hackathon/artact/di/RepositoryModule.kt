package com.hackathon.artact.di

import com.hackathon.artact.repository.AuthRepository
import com.hackathon.artact.repository.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}