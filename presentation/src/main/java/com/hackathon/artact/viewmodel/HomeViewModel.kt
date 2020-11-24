package com.hackathon.artact.viewmodel

import android.util.Log
import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Artwork
import com.hackathon.artact.usecase.artwork.GetAllArtworkUseCase
import io.reactivex.observers.DisposableSingleObserver

class HomeViewModel(
        private val getAllArtworkUseCase: GetAllArtworkUseCase
) : BaseViewModel() {

    init {
        getAllArtworks()
    }

    fun getAllArtworks() {
        addDisposable(getAllArtworkUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Artwork>>() {
            override fun onSuccess(t: List<Artwork>) {
                t.forEach {
                    Log.d("test", it.name)
                }
            }
            override fun onError(e: Throwable) {

            }
        })
    }
}