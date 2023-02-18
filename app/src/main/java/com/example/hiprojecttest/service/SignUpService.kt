package com.example.hiprojecttest.service

import com.example.hiprojecttest.dto.auth.request.SignUpDTO
import com.example.hiprojecttest.dto.email.request.EmailSendDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HEAD
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface SignUpService {
    @Headers("Content-Type: application/json")
    @POST("/auth/signup")
    fun signUp(@Body signupInfo: SignUpDTO): Call<Unit>

    @Headers("Content-Type: application/json")
    @POST("/email/send")
    fun sendEmail(@Body emailInfo: EmailSendDTO):Call<Unit>

    @Headers("Content-Type: application/json")
    @HEAD("/email")
    suspend fun emailCheck(
        @Query("email")email: String,
        @Query("authKey")authKey: String
    ): Response<Void>

}