package com.hackathon.artact.repository

import com.hackathon.artact.network.remote.AuthRemote
import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Completable

class AuthRepositoryImpl(
        private val remote: AuthRemote
) : AuthRepository {

    override fun login(loginRequest: LoginRequest): Completable =
            remote.login(loginRequest).ignoreElement()

    override fun register(registerRequest: RegisterRequest): Completable =
            remote.register(registerRequest).ignoreElement()
}