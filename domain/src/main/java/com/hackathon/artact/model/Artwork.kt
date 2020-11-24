package com.hackathon.artact.model

data class Artwork(
        val idx: Int,
        val owner: String,
        val name: String,
        val description: String,
        val uploadTime: String,
        val createdTime: String,
        val price: Int,
        val hashtag: String
)