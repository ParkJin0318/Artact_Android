package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.*
import com.hackathon.artact.usecase.artwork.GetAllArtworkUseCase
import com.hackathon.artact.usecase.goods.GetAllGoodsUseCase
import com.hackathon.artact.usecase.member.GetMyInfoUseCase
import com.hackathon.artact.usecase.order.GetAllOrderUseCase
import com.hackathon.artact.widget.recyclerview.adapter.OrderAdapter
import io.reactivex.observers.DisposableSingleObserver

class MyInfoViewModel(
        private val getMyInfoUseCase: GetMyInfoUseCase,
        private val getAllArtworkUseCase: GetAllArtworkUseCase,
        private val getAllGoodsUseCase: GetAllGoodsUseCase,
        private val getAllOrderUseCase: GetAllOrderUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val destination = MutableLiveData<String>()
    val age = MutableLiveData<String>()

    lateinit var artworks: List<Artwork>
    lateinit var goods: List<Goods>
    lateinit var orders: List<Order>

    val orderAdapter = OrderAdapter()
    val orderInfoList = ArrayList<OrderInfo>()

    init {
        orderAdapter.setList(orderInfoList)
        getAllArtwork()
    }

    fun getAllArtwork() {
        addDisposable(getAllArtworkUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Artwork>>() {
            override fun onSuccess(t: List<Artwork>) {
                artworks = t
                getAllGoods()
            }
            override fun onError(e: Throwable) {

            }
        })
    }

    fun getAllGoods() {
        addDisposable(getAllGoodsUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Goods>>() {
            override fun onSuccess(t: List<Goods>) {
                goods = t
                getAllOrders()
            }
            override fun onError(e: Throwable) {

            }
        })
    }

    fun getAllOrders() {
        addDisposable(getAllOrderUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Order>>() {
            override fun onSuccess(t: List<Order>) {
                orders = t
                setOrderData()
            }
            override fun onError(e: Throwable) {

            }
        })
    }

    fun setOrderData() {
        orderInfoList.clear()
        orders.forEach { order ->
            artworks.forEach { artwork ->
                if (order.itemIdx == artwork.idx && order.type == 0) {
                    val orderInfo = OrderInfo(order.orderDate, order.memberId, artwork.price, artwork.name, artwork.files)
                    orderInfoList.add(orderInfo)
                }
            }

            goods.forEach { goods ->
                if (order.itemIdx == goods.idx && order.type == 1) {
                    val orderInfo = OrderInfo(order.orderDate, order.memberId, goods.price, goods.name, goods.files)
                    orderInfoList.add(orderInfo)
                }
            }
        }
        orderAdapter.notifyDataSetChanged()
    }

    fun getMyInfo() {
        addDisposable(
                getMyInfoUseCase.buildUseCaseObservable(),
                object : DisposableSingleObserver<Member>() {
                    override fun onSuccess(t: Member) {
                        id.value = t.id
                        destination.value = t.destination
                        age.value = "${t.age}대"
                    }
                    override fun onError(e: Throwable) {

                    }
                })
    }
}