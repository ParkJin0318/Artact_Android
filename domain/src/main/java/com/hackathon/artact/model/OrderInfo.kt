package com.hackathon.artact.model

data class OrderInfo(
        val orderDate: String,
        val memberId: String,
        val price: Int,
        val name: String,
        val files: List<String>
)