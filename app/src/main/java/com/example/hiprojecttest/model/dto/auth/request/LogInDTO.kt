package com.example.hiprojecttest.model.dto.auth.request

import com.google.gson.annotations.SerializedName

data class LogInDTO(
    @SerializedName("email")
    val userEmail: String,
    @SerializedName("password")
    val userPassword: String
)
