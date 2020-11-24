package com.hackathon.artact.di

import com.hackathon.artact.network.service.AuthService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { (get() as Retrofit).create(AuthService::class.java) }
}