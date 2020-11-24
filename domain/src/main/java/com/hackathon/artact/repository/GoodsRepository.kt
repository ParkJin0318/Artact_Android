package com.hackathon.artact.repository

import com.hackathon.artact.model.Goods
import com.hackathon.artact.request.GoodsRequest
import io.reactivex.Completable
import io.reactivex.Single

interface GoodsRepository {
    fun getAllGoods() : Single<List<Goods>>

    fun postGoods(request: GoodsRequest) : Completable
}