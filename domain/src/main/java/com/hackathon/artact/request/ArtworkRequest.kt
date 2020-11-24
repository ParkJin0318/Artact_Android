package com.hackathon.artact.request

data class ArtworkRequest(
        val owner: String,
        val name: String,
        val description: String,
        val price: Int,
        val createTime: String
)