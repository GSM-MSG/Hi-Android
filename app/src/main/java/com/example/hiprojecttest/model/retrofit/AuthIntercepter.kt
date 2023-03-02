package com.example.hiprojecttest.model.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class AuthIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }

}