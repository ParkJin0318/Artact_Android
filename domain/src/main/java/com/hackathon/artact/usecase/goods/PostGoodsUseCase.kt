package com.hackathon.artact.usecase.goods

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.GoodsRepository
import com.hackathon.artact.request.GoodsRequest
import io.reactivex.Completable

class PostGoodsUseCase(
        private val goodsRepository: GoodsRepository
) : ParamsUseCase<PostGoodsUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
            goodsRepository.postGoods(GoodsRequest(params.owner, params.name, params.description, params.price))

    data class Params(
            val owner: String,
            val name: String,
            val description: String,
            val price: Int
    )
}