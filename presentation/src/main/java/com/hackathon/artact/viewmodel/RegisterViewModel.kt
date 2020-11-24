package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.usecase.auth.RegisterUseCase
import com.hackathon.artact.widget.SingleLiveEvent
import io.reactivex.observers.DisposableCompletableObserver

class RegisterViewModel(
        private val registerUseCase: RegisterUseCase
) : BaseViewModel() {

    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val pwConfirm = MutableLiveData<String>()
    val destination = MutableLiveData<String>()

    val onRegisterEvent = SingleLiveEvent<Unit>()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Throwable>()

    val onEmptyEvent = SingleLiveEvent<Unit>()
    val onNotMatchEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun register() {
        val isEmpty = name.value.isNullOrEmpty() || id.value.isNullOrEmpty() || pw.value.isNullOrEmpty()
                || pwConfirm.value.isNullOrEmpty() || destination.value.isNullOrEmpty()

        val isNotMath = pw.value != pwConfirm.value

        if (isEmpty) {
            onEmptyEvent.call()
            return
        }

        if (isNotMath) {
            onNotMatchEvent.call()
            return
        }

        addDisposable(
                registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(id.value!!, pw.value!!, name.value!!, age.value!!.toInt(), destination.value!!)),
                object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onSuccessEvent.call()
                    }
                    override fun onError(e: Throwable) {
                        onErrorEvent.value = e
                    }
                })
    }

    fun onRegisterClick() {
        onRegisterEvent.call()
    }

    fun onBackClick() {
        onBackEvent.call()
    }
}