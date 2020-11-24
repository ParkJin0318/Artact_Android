package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.widget.SingleLiveEvent

class RegisterViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val pwConfirm = MutableLiveData<String>()

    val onBackEvent = SingleLiveEvent<Unit>()

    fun onBackClick() {
        onBackEvent.call()
    }
}