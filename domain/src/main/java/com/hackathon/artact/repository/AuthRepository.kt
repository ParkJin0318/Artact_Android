package com.hackathon.artact.repository

import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun login(loginRequest: LoginRequest): Single<String>

    fun register(registerRequest: RegisterRequest): Completable
}