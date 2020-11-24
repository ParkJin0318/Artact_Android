package com.hackathon.artact.network.remote

import com.hackathon.artact.base.BaseRemote
import com.hackathon.artact.model.Goods
import com.hackathon.artact.network.repoonse.GoodsData
import com.hackathon.artact.network.service.GoodsService
import com.hackathon.artact.request.GoodsRequest
import io.reactivex.Single

class GoodsRemote(override val service: GoodsService) : BaseRemote<GoodsService>() {

    fun getAllGoods() : Single<List<Goods>> =
            service.getAllGoods().map(getResponseData()).map(GoodsData::goods)

    fun postGoods(request: GoodsRequest) : Single<String> =
            service.postGoods(request).map(getResponseMessage())
}