package com.hackathon.artact.network.service

import com.hackathon.artact.network.Response
import com.hackathon.artact.network.repoonse.GoodsData
import com.hackathon.artact.request.GoodsRequest
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface GoodsService {

    // 굿즈 목록 조회
    @GET("work/goods")
    fun getAllGoods() : Single<retrofit2.Response<Response<GoodsData>>>

    // 굿즈 생성
    @POST("work/goods")
    fun postGoods(request: GoodsRequest) : Single<retrofit2.Response<Response<Any>>>
}