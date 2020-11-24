package com.hackathon.artact.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Artwork

class ArtworkItemViewModel : BaseViewModel() {

    val image = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    fun bind(item: Artwork) {
        image.value = null
        name.value = null

        val images = item.files
        if (images.isNotEmpty()) {
            image.value = images[0]
        }
        name.value = item.name
    }
}