package com.hackathon.artact.network.remote

import com.hackathon.artact.base.RetrofitRemote
import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import com.hackathon.artact.network.service.AuthService
import io.reactivex.Single

class AuthRemote : RetrofitRemote<AuthService>() {

    override val service: AuthService
        get() = createService(AuthService::class.java)

    fun login(request: LoginRequest): Single<String> =
            service.login(request).map(getResponseMessage())

    fun register(request: RegisterRequest): Single<String> =
            service.register(request).map(getResponseMessage())
}