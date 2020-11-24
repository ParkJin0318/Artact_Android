package com.hackathon.artact.repository

import com.hackathon.artact.model.Order
import com.hackathon.artact.network.remote.OrderRemote
import com.hackathon.artact.request.OrderRequest
import io.reactivex.Completable
import io.reactivex.Single

class OrderRepositoryImpl(
        private val orderRemote: OrderRemote
) : OrderRepository {

    override fun getAllOrder(): Single<List<Order>> =
            orderRemote.getAllOrder()

    override fun postOrder(request: OrderRequest): Completable =
            orderRemote.postOrder(request).ignoreElement()
}