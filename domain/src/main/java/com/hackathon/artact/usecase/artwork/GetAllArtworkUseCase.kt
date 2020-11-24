package com.hackathon.artact.usecase.artwork

import com.hackathon.artact.base.BaseUseCase
import com.hackathon.artact.model.Artwork
import com.hackathon.artact.repository.ArtworkRepository
import io.reactivex.Single

class GetAllArtworkUseCase(
        private val artworkRepository: ArtworkRepository
) : BaseUseCase<Single<List<Artwork>>>() {

    override fun buildUseCaseObservable(): Single<List<Artwork>> =
            artworkRepository.getAllArtwork()
}