package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.util.DataObject
import com.hackathon.artact.widget.SingleLiveEvent

class GoodsViewModel : BaseViewModel() {
    val image = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val price = MutableLiveData<String>()

    val onBackEvent = SingleLiveEvent<Unit>()

    init {
        val goods = DataObject.getGoods()
        val images = goods.files

        if (images.isNotEmpty()) image.value = images[0]
        name.value = goods.name
        userName.value = goods.owner
        description.value = goods.description
        date.value = goods.uploadTime.substring(0, 10)
        price.value = "${goods.price}원"
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}