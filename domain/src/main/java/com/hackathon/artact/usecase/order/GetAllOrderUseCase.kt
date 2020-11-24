package com.hackathon.artact.usecase.order

import com.hackathon.artact.base.BaseUseCase
import com.hackathon.artact.model.Order
import com.hackathon.artact.repository.OrderRepository
import io.reactivex.Single

class GetAllOrderUseCase(
        private val orderRepository: OrderRepository
) : BaseUseCase<Single<List<Order>>>() {

    override fun buildUseCaseObservable(): Single<List<Order>> =
            orderRepository.getAllOrder()
}