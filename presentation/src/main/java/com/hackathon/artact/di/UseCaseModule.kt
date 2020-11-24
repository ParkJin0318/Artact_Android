package com.hackathon.artact.di

import com.hackathon.artact.usecase.artwork.GetAllArtworkUseCase
import com.hackathon.artact.usecase.artwork.PostArtworkUseCase
import com.hackathon.artact.usecase.member.GetMyInfoUseCase
import com.hackathon.artact.usecase.auth.LoginUseCase
import com.hackathon.artact.usecase.auth.RegisterUseCase
import com.hackathon.artact.usecase.goods.GetAllGoodsUseCase
import com.hackathon.artact.usecase.goods.PostGoodsUseCase
import com.hackathon.artact.usecase.order.GetAllOrderUseCase
import com.hackathon.artact.usecase.order.PostOrderUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }

    single { GetMyInfoUseCase(get()) }

    single { GetAllGoodsUseCase(get()) }
    single { PostGoodsUseCase(get()) }

    single { GetAllArtworkUseCase(get()) }
    single { PostArtworkUseCase(get()) }

    single { GetAllOrderUseCase(get()) }
    single { PostOrderUseCase(get()) }
}