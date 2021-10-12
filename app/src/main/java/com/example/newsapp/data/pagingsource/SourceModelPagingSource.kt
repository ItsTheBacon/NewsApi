package com.example.newsapp.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import com.example.newsapp.models.Source
import java.io.IOException

class SourceModelPagingSource(private val service: TopHeadLinesApiService) :
    PagingSource<Int, Source>() {
    override fun getRefreshKey(state: PagingState<Int, Source>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Source> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = service.fetchSource(nextPageNumber)
            val nextPage = nextPageNumber + 1
            LoadResult.Page(
                data = response.sources,
                prevKey = null, // Only paging forward.
                nextKey = nextPage
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}