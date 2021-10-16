package com.example.newsapp.data.network.apiservices

import com.example.newsapp.models.Everything
import com.example.newsapp.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {
    @GET("/v2/everything?apiKey=a4abe61c730f4b39ab111c9630def7c4")
    suspend fun fetchEverything(
        @Query("page") page: Int,
        @Query("q") query: String = "bitcoin"
    ): NewsResponse<Everything>
}