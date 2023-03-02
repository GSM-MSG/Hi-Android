package com.example.hiprojecttest.model.dto.auth.response

import com.google.gson.annotations.SerializedName

data class LogInResponseDTO(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String,
    @SerializedName("expireAt")
    val expireAt: String
)
