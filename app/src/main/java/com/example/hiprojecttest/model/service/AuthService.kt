package com.example.hiprojecttest.model.service

import com.example.hiprojecttest.model.dto.auth.request.LogInDTO
import com.example.hiprojecttest.model.dto.auth.request.SignUpDTO
import com.example.hiprojecttest.model.dto.auth.response.LogInResponseDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @POST("/auth/signup")
    fun signUp(@Body signupInfo: SignUpDTO): Call<Unit>

    @POST("/auth/login")
    fun logIn(@Body loginInfo: LogInDTO): Call<LogInResponseDTO>

}