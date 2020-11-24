package com.hackathon.artact.repository

import com.hackathon.artact.model.Goods
import com.hackathon.artact.network.remote.GoodsRemote
import com.hackathon.artact.request.GoodsRequest
import io.reactivex.Completable
import io.reactivex.Single

class GoodsRepositoryImpl(
        private val goodsRemote: GoodsRemote
) : GoodsRepository {

    override fun getAllGoods(): Single<List<Goods>> =
            goodsRemote.getAllGoods()

    override fun postGoods(request: GoodsRequest): Completable =
            goodsRemote.postGoods(request).ignoreElement()
}