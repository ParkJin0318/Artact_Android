package com.hackathon.artact.model

data class Order(
        val idx: Int,
        val orderDate: String,
        val memberId: String,
        val type: Int,
        val itemIdx: Int
)