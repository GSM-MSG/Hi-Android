package com.example.hiprojecttest.model.service

import com.example.hiprojecttest.model.dto.email.request.EmailSendDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HEAD
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface EmailService {
    @POST("/email/send")
    fun sendEmail(@Body emailInfo: EmailSendDTO):Call<Unit>

    @HEAD("/email")
    suspend fun emailCheck(
        @Query("email")email: String,
        @Query("authKey")authKey: String
    ): Response<Void>

}