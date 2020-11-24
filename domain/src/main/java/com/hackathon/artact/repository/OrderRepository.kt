package com.hackathon.artact.repository

import com.hackathon.artact.model.Order
import com.hackathon.artact.request.OrderRequest
import io.reactivex.Completable
import io.reactivex.Single

interface OrderRepository {
    fun getAllOrder() : Single<List<Order>>

    fun postOrder(request: OrderRequest) : Completable
}