package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.usecase.LoginUseCase
import com.hackathon.artact.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class LoginViewModel(
        private val loginUseCase: LoginUseCase
) : BaseViewModel() {

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

        addDisposable(loginUseCase.buildUseCaseObservable(LoginUseCase.Params(id.value!!, pw.value!!)),
                object : DisposableCompletableObserver() {
                override fun onComplete() {
                    onSuccessEvent.call()
                }
                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }
        })
    }

    fun onLoginClick() {
        onLoginEvent.call()
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}