package com.hackathon.artact.network

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)