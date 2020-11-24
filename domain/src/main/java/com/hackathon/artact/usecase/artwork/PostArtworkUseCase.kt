package com.hackathon.artact.usecase.artwork

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.ArtworkRepository
import com.hackathon.artact.request.ArtworkRequest
import io.reactivex.Completable

class PostArtworkUseCase(
        private val artworkRepository: ArtworkRepository
) : ParamsUseCase<PostArtworkUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
            artworkRepository.postArtwork(ArtworkRequest(params.owner, params.name, params.description, params.price, params.createTime))

    data class Params(
            val owner: String,
            val name: String,
            val description: String,
            val price: Int,
            val createTime: String
    )
}