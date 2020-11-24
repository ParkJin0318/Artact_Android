package com.hackathon.artact.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.OrderInfo

class OrderItemViewModel : BaseViewModel() {
    val name = MutableLiveData<String>()
    val price = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val image = MutableLiveData<String>()

    fun bind(item: OrderInfo) {
        name.value = item.name
        price.value = "${item.price}원"
        date.value = item.orderDate.substring(0, 10)
        userName.value = item.memberId

        if (item.files.isNotEmpty()) image.value = item.files[0]
    }
}