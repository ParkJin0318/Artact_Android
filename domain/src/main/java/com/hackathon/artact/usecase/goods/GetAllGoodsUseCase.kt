package com.hackathon.artact.usecase.goods

import com.hackathon.artact.base.BaseUseCase
import com.hackathon.artact.model.Goods
import com.hackathon.artact.repository.GoodsRepository
import io.reactivex.Single

class GetAllGoodsUseCase(
        private val goodsRepository: GoodsRepository
): BaseUseCase<Single<List<Goods>>>() {

    override fun buildUseCaseObservable(): Single<List<Goods>> =
            goodsRepository.getAllGoods()
}