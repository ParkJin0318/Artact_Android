package com.hackathon.artact.repository

import com.hackathon.artact.network.repoonse.LoginData
import com.hackathon.artact.network.remote.AuthRemote
import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Completable
import io.reactivex.Single

class AuthRepositoryImpl(
        private val authRemote: AuthRemote
) : AuthRepository {

    override fun login(loginRequest: LoginRequest): Single<String> =
            authRemote.login(loginRequest)

    override fun register(registerRequest: RegisterRequest): Completable =
            authRemote.register(registerRequest).ignoreElement()
}