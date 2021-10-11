package com.example.newsapp.ui.fragments.topheadline

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.repositories.TopHeadLinesRepository
import com.example.newsapp.models.Everything
import com.example.newsapp.resouce.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TopHeadLinesViewModel @Inject constructor(private val repository: TopHeadLinesRepository) : BaseViewModel() {

    val topHeadLines : MutableLiveData<List<Everything>> = MutableLiveData()

    fun fetchTopHeadLines(){
        viewModelScope.launch {
            repository.fetchTopHeadLines().collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("tag", "Loading: "  + it.data)

                    }
                    is Resource.Error -> {
                        Log.e("tag", "error: "  + it.data)

                    }
                    is Resource.Success -> {
                        topHeadLines.postValue(it.data?.body()?.articles)
                        Log.d("tag", "Success: ${it.data}")
                    }
                }
            }
        }
    }
}