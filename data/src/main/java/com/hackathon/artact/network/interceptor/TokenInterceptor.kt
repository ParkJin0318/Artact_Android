package com.hackathon.artact.network.interceptor

import android.app.Application
import com.hackathon.artact.util.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    private val application: Application
) : Interceptor {

    lateinit var token: String

    override fun intercept(chain: Interceptor.Chain): Response {
        setToken()

        val request= chain.request().newBuilder().header("x-access-token", token).build()
        return chain.proceed(request)
    }

    private fun setToken() {
        token = SharedPreferenceManager.getToken(application)!!
    }
}