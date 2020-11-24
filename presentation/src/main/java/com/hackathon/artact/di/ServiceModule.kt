package com.hackathon.artact.di

import com.hackathon.artact.network.service.*
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { (get() as Retrofit).create(AuthService::class.java) }
    single { (get() as Retrofit).create(MemberService::class.java) }
    single { (get() as Retrofit).create(ArtworkService::class.java) }
    single { (get() as Retrofit).create(OrderService::class.java) }
    single { (get() as Retrofit).create(GoodsService::class.java) }
}