package com.hackathon.artact.viewmodel

import com.hackathon.artact.base.BaseViewModel
import com.hackathon.artact.model.Artwork
import com.hackathon.artact.usecase.artwork.GetAllArtworkUseCase
import com.hackathon.artact.widget.recyclerview.adapter.ArtworkAdapter
import io.reactivex.observers.DisposableSingleObserver

class HomeViewModel(
        private val getAllArtworkUseCase: GetAllArtworkUseCase
) : BaseViewModel() {

    val artworkAdapter = ArtworkAdapter()
    val artworkList = ArrayList<Artwork>()

    init {
        artworkAdapter.setList(artworkList)
    }

    fun getAllArtworks() {
        addDisposable(getAllArtworkUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<Artwork>>() {
            override fun onSuccess(t: List<Artwork>) {
                artworkList.clear()
                artworkList.addAll(t)
                artworkAdapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {

            }
        })
    }
}