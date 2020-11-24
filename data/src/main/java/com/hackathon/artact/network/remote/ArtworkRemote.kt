package com.hackathon.artact.network.remote

import com.hackathon.artact.base.BaseRemote
import com.hackathon.artact.model.Artwork
import com.hackathon.artact.network.repoonse.ArtworkData
import com.hackathon.artact.network.service.ArtworkService
import com.hackathon.artact.request.ArtworkRequest
import io.reactivex.Single

class ArtworkRemote(override val service: ArtworkService) : BaseRemote<ArtworkService>() {

    fun getAllArtwork() : Single<List<Artwork>> =
            service.getAllArtwork().map(getResponseData()).map(ArtworkData::artworks)

    fun postArtwork(request: ArtworkRequest) : Single<String> =
            service.postArtwork(request).map(getResponseMessage())
}