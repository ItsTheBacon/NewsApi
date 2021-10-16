package com.example.newsapp.data.network.apiservices

import com.example.newsapp.models.Everything
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.models.Source
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadLinesApiService {
    @GET("v2/top-headlines")
    suspend fun fetchTopHeadLinesTechnology(
        @Query("page") page: Int,
        @Query("country") countryCode: String = "id",
        @Query("category") category: String = "Technology",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse<Everything>

    companion object {
        private const val API_KEY = "a4abe61c730f4b39ab111c9630def7c4"
    }

    @GET("v2/top-headlines/sources")
    suspend fun fetchSource(
        @Query("page") page: Int,
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse<Source>

}