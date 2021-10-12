package com.example.newsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import com.example.newsapp.data.pagingsource.SourceModelPagingSource
import com.example.newsapp.data.pagingsource.TopHeadLinesPagingSource
import com.example.newsapp.models.Everything
import com.example.newsapp.models.Source
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadLinesRepository @Inject constructor(private val service: TopHeadLinesApiService) {

    fun fetchTopHeadLines(): Flow<PagingData<Everything>> {
        return Pager(config =
        PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                TopHeadLinesPagingSource(service)
            }
        ).flow
    }

    fun fetchSource(): Flow<PagingData<Source>> {
        return Pager(config =
        PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                SourceModelPagingSource(service)
            }
        ).flow
    }
}