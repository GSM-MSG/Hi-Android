package com.example.hiprojecttest.model.service

import com.example.hiprojecttest.model.dto.auth.request.SignUpDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers("Content-Type: application/json")
    @POST("/auth/signup")
    fun signUp(@Body signupInfo: SignUpDTO): Call<Unit>
}