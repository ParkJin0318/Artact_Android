package com.hackathon.artact.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.usecase.auth.LoginUseCase
import com.hackathon.artact.util.SharedPreferenceManager
import com.hackathon.artact.widget.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver

class LoginViewModel(
        private val application: Application,
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
                object : DisposableSingleObserver<String>() {
                    override fun onSuccess(t: String) {
                        SharedPreferenceManager.setToken(application, t)
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