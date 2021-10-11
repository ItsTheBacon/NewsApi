package com.example.newsapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newsapp.data.network.apiservices.EverythingApiService
import com.example.newsapp.models.Everything
import java.io.IOException

//private const val STARTING_PAGE_INDEX = 1
//
//class EverythingAdapter(
//    private val service: EverythingApiService,
//    private val query: String = ""
//) : PagingSource<Int, Everything>() {
//    override fun getRefreshKey(state: PagingState<Int, Everything>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
//        }
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Everything> {
//        val page = params.key ?: STARTING_PAGE_INDEX
//
//        return try {
//            val response = if (query.isNotEmpty()) service.fetchEverything(
//                page = page,
//                pageSize = params.loadSize,
//                query = query
//            )
//            else service.fetchEverything(page = page, pageSize = params.loadSize)
//            val news = response.body()?.articles
//
//            LoadResult.Page(
//                data = news ?: emptyList(),
//                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
//                nextKey = if (page == response.body()?.totalResults) null else page + 1
//            )
//        } catch (exception: IOException) {
//            val error = IOException("Please Check Internet Connection")
//            LoadResult.Error(error)
//        } catch (exception: HttpException) {
//            LoadResult.Error(exception)
//        }
//
//    }
//
//}
//