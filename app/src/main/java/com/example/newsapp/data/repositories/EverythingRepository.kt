package com.example.newsapp.data.repositories

import com.example.newsapp.base.BaseRepository
import com.example.newsapp.data.network.apiservices.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(
    private val service: EverythingApiService
) :
    BaseRepository() {

        fun fetchEverything(query : String  = "bitcoin") = doRequest{
            service.fetchEverything(query)
        }
}