package com.hackathon.artact.network.service

import com.hackathon.artact.network.Response
import com.hackathon.artact.network.repoonse.OrderData
import com.hackathon.artact.request.OrderRequest
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderService {

    // 주문 목록 조회
    @GET("order")
    fun getAllOrder() : Single<retrofit2.Response<Response<OrderData>>>

    //주문 생성
    @POST("order")
    fun postOrder(request: OrderRequest): Single<retrofit2.Response<Response<Any>>>
}