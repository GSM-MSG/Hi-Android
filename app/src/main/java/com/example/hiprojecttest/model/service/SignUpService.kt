package com.example.hiprojecttest.model.service

import androidx.core.content.UnusedAppRestrictionsBackportService
import com.example.hiprojecttest.model.dto.auth.request.SignUpDTO
import com.example.hiprojecttest.model.dto.email.request.EmailSendDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HEAD
import retrofit2.http.Headers

import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SignUpService {
    @Headers("Content-Type: application/json")
    @POST("/auth/signup")
    fun signUp(@Body signupInfo: SignUpDTO): Call<Unit>

    @Headers("Content-Type: application/json")
    @POST("/email/send")
    fun sendEmail(@Body emailInfo: EmailSendDTO):Call<Unit>

    @Headers("Content-Type: application/json")
    @HEAD("/email/")
    fun emailCheck(
        @Query("email")email: String,
        @Query("authKey")authKey: String
    ): Call<Unit>

}