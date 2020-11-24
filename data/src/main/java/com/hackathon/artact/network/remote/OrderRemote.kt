package com.hackathon.artact.network.remote

import com.hackathon.artact.base.BaseRemote
import com.hackathon.artact.model.Order
import com.hackathon.artact.network.repoonse.OrderData
import com.hackathon.artact.network.service.OrderService
import com.hackathon.artact.request.OrderRequest
import io.reactivex.Single

class OrderRemote(
        override val service: OrderService
) : BaseRemote<OrderService>() {

    fun getAllOrder() : Single<List<Order>> =
            service.getAllOrder().map(getResponseData()).map(OrderData::orders)

    fun postOrder(request: OrderRequest) : Single<String> =
            service.postOrder(request).map(getResponseMessage())
}