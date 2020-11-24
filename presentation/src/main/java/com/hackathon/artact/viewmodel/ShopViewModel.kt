package com.hackathon.artact.viewmodel

import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Goods
import com.hackathon.artact.usecase.goods.GetAllGoodsUseCase
import com.hackathon.artact.widget.recyclerview.adapter.GoodsAdapter
import io.reactivex.observers.DisposableSingleObserver

class ShopViewModel(
        private val getAllGoodsUseCase: GetAllGoodsUseCase
) : BaseViewModel() {

    val goodsAdapter = GoodsAdapter()
    val goodsList = ArrayList<Goods>()

    init {
        goodsAdapter.setList(goodsList)
    }

    fun getAllGoods() {
        addDisposable(getAllGoodsUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Goods>>() {
            override fun onSuccess(t: List<Goods>) {
                goodsList.clear()
                goodsList.addAll(t)
                goodsAdapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {

            }
        })
    }
}