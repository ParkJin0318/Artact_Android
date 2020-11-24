package com.hackathon.artact.repository

import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Completable

interface AuthRepository {
    fun login(loginRequest: LoginRequest): Completable

    fun register(registerRequest: RegisterRequest): Completable
}