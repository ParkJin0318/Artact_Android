package com.hackathon.artact.repository

import com.hackathon.artact.model.Artwork
import com.hackathon.artact.network.remote.ArtworkRemote
import com.hackathon.artact.request.ArtworkRequest
import io.reactivex.Completable
import io.reactivex.Single

class ArtworkRepositoryImpl(
        private val artworkRemote: ArtworkRemote
) : ArtworkRepository {
    override fun getAllArtwork(): Single<List<Artwork>> =
            artworkRemote.getAllArtwork()

    override fun postArtwork(request: ArtworkRequest): Completable =
            artworkRemote.postArtwork(request).ignoreElement()
}