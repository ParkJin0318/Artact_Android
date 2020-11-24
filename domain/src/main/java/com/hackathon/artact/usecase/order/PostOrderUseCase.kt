package com.hackathon.artact.usecase.order

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.OrderRepository
import com.hackathon.artact.request.OrderRequest
import io.reactivex.Completable

class PostOrderUseCase(
        private val orderRepository: OrderRepository
) : ParamsUseCase<PostOrderUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
            orderRepository.postOrder(OrderRequest(params.type, params.itemIdx))

    data class Params(
            val type: Int,
            val itemIdx: Int
    )
}