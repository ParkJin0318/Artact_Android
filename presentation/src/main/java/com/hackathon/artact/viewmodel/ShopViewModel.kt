package com.hackathon.artact.viewmodel

import android.util.Log
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Goods
import com.hackathon.artact.usecase.goods.GetAllGoodsUseCase
import io.reactivex.observers.DisposableSingleObserver

class ShopViewModel(
        private val getAllGoodsUseCase: GetAllGoodsUseCase
) : BaseViewModel() {

    init {
        getAllGoods()
    }

    fun getAllGoods() {
        addDisposable(getAllGoodsUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Goods>>() {
            override fun onSuccess(t: List<Goods>) {
                t.forEach {
                    Log.d("test", it.name)
                }
            }
            override fun onError(e: Throwable) {

            }
        })
    }
}