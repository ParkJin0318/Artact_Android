package com.hackathon.artact.viewmodel

import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.widget.SingleLiveEvent

class IntroViewModel : BaseViewModel() {
    val onLoginEvent = SingleLiveEvent<Unit>()
    val onRegisterEvent = SingleLiveEvent<Unit>()

    fun onLoginClick() {
        onLoginEvent.call()
    }

    fun onRegisterClick() {
        onRegisterEvent.call()
    }
}