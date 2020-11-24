package com.hackathon.artact.request

data class GoodsRequest(
        val owner: String,
        val name: String,
        val description: String,
        val price: Int
)