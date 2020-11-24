package com.hackathon.artact.viewmodel

import androidx.lifecycle.MutableLiveData
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Member
import com.hackathon.artact.usecase.member.GetMyInfoUseCase
import io.reactivex.observers.DisposableSingleObserver

class MyInfoViewModel(
        private val getMyInfoUseCase: GetMyInfoUseCase
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val destination = MutableLiveData<String>()
    val age = MutableLiveData<String>()

    fun getMyInfo() {
        addDisposable(
                getMyInfoUseCase.buildUseCaseObservable(),
                object : DisposableSingleObserver<Member>() {
                    override fun onSuccess(t: Member) {
                        id.value = t.id
                        destination.value = t.destination
                        age.value = "${t.age}대"
                    }
                    override fun onError(e: Throwable) {

                    }
                })
    }
}