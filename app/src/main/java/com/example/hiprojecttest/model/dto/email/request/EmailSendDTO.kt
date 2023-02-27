package com.example.hiprojecttest.model.dto.email.request

import com.google.gson.annotations.SerializedName

data class EmailSendDTO (
    @SerializedName("email")
    val email: String
    )

