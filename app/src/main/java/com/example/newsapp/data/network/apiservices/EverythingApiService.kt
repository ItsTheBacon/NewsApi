package com.example.newsapp.data.network.apiservices

import com.example.newsapp.models.Everything
import com.example.newsapp.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {
    @GET("/v2/everything?apiKey=00fe493257b24f1f8a68507f1aba0ce6")
    suspend fun fetchEverything(
        @Query("page") page: Int,
        @Query("q") query: String = "bitcoin"
    ): NewsResponse<Everything>
}