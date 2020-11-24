package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.widget.SingleLiveEvent

class LoginViewModel : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    val onLoginEvent = SingleLiveEvent<Unit>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Throwable>()

    val onEmptyEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun login() {
        val isEmpty = id.value.isNullOrEmpty() || pw.value.isNullOrEmpty()

        if (isEmpty) {
            onEmptyEvent.call()
            return
        }

        // Login Code
        onSuccessEvent.call()
    }

    fun onLoginClick() {
        onLoginEvent.call()
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}