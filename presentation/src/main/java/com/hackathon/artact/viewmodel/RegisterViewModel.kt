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

    val onRegisterEvent = SingleLiveEvent<Unit>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Throwable>()

    val onEmptyEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun register() {
        val isEmpty = name.value.isNullOrEmpty() || id.value.isNullOrEmpty()
                || pw.value.isNullOrEmpty() || pwConfirm.value.isNullOrEmpty()

        if (isEmpty) {
            onEmptyEvent.call()
            return
        }

        // Register Code
    }

    fun onRegisterClick() {
        onRegisterEvent.call()
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}