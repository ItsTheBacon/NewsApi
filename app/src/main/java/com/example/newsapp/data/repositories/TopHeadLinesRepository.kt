package com.example.newsapp.data.repositories

import com.example.newsapp.base.BaseRepository
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import javax.inject.Inject

class TopHeadLinesRepository @Inject constructor(private val service: TopHeadLinesApiService) :
    BaseRepository() {

    fun fetchTopHeadLines() = doRequest {
        service.fetchTopHeadLinesTechnology()
    }
    fun fetchSource() = doRequest{
        service.fetchSource()
    }
}