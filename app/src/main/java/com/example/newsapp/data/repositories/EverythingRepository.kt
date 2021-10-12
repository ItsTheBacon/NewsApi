package com.example.newsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.network.apiservices.EverythingApiService
import com.example.newsapp.data.pagingsource.EverythingPagingSource
import com.example.newsapp.models.Everything
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EverythingRepository @Inject constructor(
    private val service: EverythingApiService
) {

    fun fetchEverything(): Flow<PagingData<Everything>> {
        return Pager(config =
        PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                EverythingPagingSource(service)
            }
        ).flow
    }
}