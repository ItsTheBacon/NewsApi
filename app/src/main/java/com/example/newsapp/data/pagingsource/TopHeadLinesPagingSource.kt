package com.example.newsapp.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import com.example.newsapp.models.Everything
import java.io.IOException


class TopHeadLinesPagingSource(private val service: TopHeadLinesApiService) :
    PagingSource<Int, Everything>() {
    override fun getRefreshKey(state: PagingState<Int, Everything>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Everything> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = service.fetchTopHeadLinesTechnology(nextPageNumber)
            val nextPage = nextPageNumber + 1
            LoadResult.Page(
                data = response.articles,
                prevKey = null, // Only paging forward.
                nextKey = nextPage
            )
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}