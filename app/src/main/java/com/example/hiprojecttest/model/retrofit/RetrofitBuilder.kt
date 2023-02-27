package com.example.hiprojecttest.model.retrofit

import com.example.hiprojecttest.model.service.AuthService
import com.example.hiprojecttest.model.service.EmailService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://port-0-hi-backend-1b5xkk2fldr011vx.gksl2.cloudtype.app/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val emailService: EmailService by lazy {
        retrofit.create(EmailService::class.java)
    }
    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }
}
