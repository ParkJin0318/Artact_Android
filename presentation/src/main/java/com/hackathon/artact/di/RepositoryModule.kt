package com.hackathon.artact.di

import com.hackathon.artact.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<MemberRepository> { MemberRepositoryImpl(get()) }
    single<GoodsRepository> { GoodsRepositoryImpl(get()) }
    single<ArtworkRepository> { ArtworkRepositoryImpl(get()) }
    single<OrderRepository> { OrderRepositoryImpl(get()) }
}