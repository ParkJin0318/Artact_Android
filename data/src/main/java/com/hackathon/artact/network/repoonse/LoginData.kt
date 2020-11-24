package com.hackathon.artact.network.repoonse

import com.google.gson.annotations.SerializedName

data class LoginData(
        @SerializedName("x-access-token")
        val token: String
)