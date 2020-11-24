package com.hackathon.artact.repository

import com.hackathon.artact.model.Artwork
import com.hackathon.artact.request.ArtworkRequest
import io.reactivex.Completable
import io.reactivex.Single

interface ArtworkRepository {
    fun getAllArtwork() : Single<List<Artwork>>

    fun postArtwork(request: ArtworkRequest) : Completable
}