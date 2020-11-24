package com.hackathon.artact.network.service

import com.hackathon.artact.network.repoonse.LoginData
import com.hackathon.artact.network.Response
import com.hackathon.artact.request.LoginRequest
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    // 로그인
    @POST("auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Single<retrofit2.Response<Response<LoginData>>>

    // 회원가입
    @POST("auth/register")
    fun register(
        @Body registerRequest: RegisterRequest
    ): Single<retrofit2.Response<Response<Any>>>
}