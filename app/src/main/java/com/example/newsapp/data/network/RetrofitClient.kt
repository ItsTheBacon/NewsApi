package com.example.newsapp.data.network

import com.example.newsapp.constants.Constants.BASE_URL
import com.example.newsapp.data.network.apiservices.EverythingApiService
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import com.example.newsapp.data.network.interceptors.AuthorizationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient : OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
//        .addInterceptor(AuthorizationInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()


    private fun provideLoggingInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val provideRetrofit  = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideEveryThingApiService(): EverythingApiService = provideRetrofit.create(
        EverythingApiService::class.java
    )
    fun provideTopHeadLinesApiSerVice() : TopHeadLinesApiService = provideRetrofit.create(
        TopHeadLinesApiService::class.java
    )
}