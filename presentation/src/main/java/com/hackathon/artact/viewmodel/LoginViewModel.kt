package com.hackathon.artact.viewmodel

import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.widget.SingleLiveEvent

class LoginViewModel : BaseViewModel() {
    val onBackEvent = SingleLiveEvent<Unit>()

    fun onBackClick() {
        onBackEvent.call()
    }
}