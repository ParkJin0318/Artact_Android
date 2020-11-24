package com.hackathon.artact.network.service

import com.hackathon.artact.network.Response
import com.hackathon.artact.network.repoonse.ArtworkData
import com.hackathon.artact.request.ArtworkRequest
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface ArtworkService {

    // 작품 목록 조회
    @GET("work/art")
    fun getAllArtwork() : Single<retrofit2.Response<Response<ArtworkData>>>

    // 작품 생성
    @POST("work/art")
    fun postArtwork(request: ArtworkRequest) : Single<retrofit2.Response<Response<Any>>>
}