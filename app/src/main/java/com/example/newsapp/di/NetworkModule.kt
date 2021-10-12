package com.example.newsapp.di

import com.example.newsapp.data.network.RetrofitClient
import com.example.newsapp.data.network.apiservices.EverythingApiService
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    val retrofit: RetrofitClient = RetrofitClient()


    @Singleton
    @Provides
    fun fetchEveryThingApiService(): EverythingApiService {
        return retrofit.provideEveryThingApiService()
    }

    @Singleton
    @Provides
    fun fetchTopHeadLines(): TopHeadLinesApiService {
        return retrofit.provideTopHeadLinesApiSerVice()
    }
}