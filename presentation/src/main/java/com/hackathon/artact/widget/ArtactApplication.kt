package com.hackathon.artact.widget

import android.app.Application
import com.hackathon.artact.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArtactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArtactApplication)

            val modules =
                listOf(viewModelModule)
            modules(modules)
        }
    }
}