package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.util.DataObject
import com.hackathon.artact.widget.SingleLiveEvent

class ArtworkViewModel : BaseViewModel() {
    val image = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val date = MutableLiveData<String>()
    val price = MutableLiveData<String>()

    val onBackEvent = SingleLiveEvent<Unit>()

    init {
        val artwork = DataObject.getArtwork()
        val images = artwork.files

        if (images.isNotEmpty()) image.value = images[0]
        name.value = artwork.name
        userName.value = artwork.owner
        description.value = artwork.description
        date.value = artwork.uploadTime.substring(0, 10)
        price.value = "${artwork.price}원"
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}