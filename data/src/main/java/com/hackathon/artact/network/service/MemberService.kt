package com.hackathon.artact.network.service

import com.hackathon.artact.network.Response
import com.hackathon.artact.network.repoonse.MemberData
import io.reactivex.Single
import retrofit2.http.GET

interface MemberService {

    // 내 정보
    @GET("auth/my")
    fun getMyInfo(): Single<retrofit2.Response<Response<MemberData>>>
}