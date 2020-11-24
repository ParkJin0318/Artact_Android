package com.hackathon.artact.widget

import android.app.Application
import com.hackathon.artact.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArtactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArtactApplication)

            val modules =
                listOf(networkModule, serviceModule, remoteModule,
                    repositoryModule, useCaseModule, viewModelModule)
            modules(modules)
        }
    }
}