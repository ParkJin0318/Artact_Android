package com.hackathon.artact.di

import com.hackathon.artact.network.remote.AuthRemote
import org.koin.dsl.module

val remoteModule = module {
    single { AuthRemote() }
}