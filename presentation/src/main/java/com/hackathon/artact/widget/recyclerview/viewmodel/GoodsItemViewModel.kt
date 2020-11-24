package com.hackathon.artact.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Goods

class GoodsItemViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()
    val image = MutableLiveData<String>()

    fun bind(item: Goods) {
        image.value = null
        name.value = null

        val images = item.files
        if (images.isNotEmpty()) {
            image.value = images[0]
        }
        name.value = item.name
    }
}