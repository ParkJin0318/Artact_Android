package com.hackathon.artact.di

import com.hackathon.artact.network.remote.*
import org.koin.dsl.module
import kotlin.math.sin

val remoteModule = module {
    single { AuthRemote() }
    single { MemberRemote(get()) }
    single { ArtworkRemote(get()) }
    single { GoodsRemote(get()) }
    single { OrderRemote(get()) }
}