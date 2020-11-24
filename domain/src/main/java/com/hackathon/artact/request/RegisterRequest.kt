package com.hackathon.artact.request

data class RegisterRequest(
        val id: String,
        val pw: String,
        val name: String,
        val age: Int
)