package com.example.newsapp.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "00fe493257b24f1f8a68507f1aba0ce6")
            .build()
        return chain.proceed(request)
    }
}