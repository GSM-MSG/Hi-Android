package com.example.hiprojecttest.model.dto.auth.request

import com.google.gson.annotations.SerializedName

data class SignUpDTO(
    @SerializedName("email")
    val memberEmail: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String
)