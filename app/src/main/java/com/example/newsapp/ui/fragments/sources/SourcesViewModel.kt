package com.example.newsapp.ui.fragments.sources

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.base.BaseRepository
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.network.apiservices.TopHeadLinesApiService
import com.example.newsapp.data.repositories.TopHeadLinesRepository
import com.example.newsapp.models.Everything
import com.example.newsapp.models.Source
import com.example.newsapp.resouce.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(private val repository: TopHeadLinesRepository) :
    BaseViewModel() {
    val sources : MutableLiveData<List<Source>> = MutableLiveData()

    fun fetchSource(){
        viewModelScope.launch {
            repository.fetchSource().collect {
                when(it){
                    is Resource.Loading -> {
                        Log.e("anime", "sources Loading: "  + it.data)

                    }
                    is Resource.Error -> {
                        Log.e("anime", "sources error: "  + it.message.toString())

                    }
                    is Resource.Success -> {
//                        sources.postValue(it.data?.body()?.articles)
                        Log.d("anime", "sources Success: ${it.data?.body()?.articles.toString()}")
                    }
                }

            }
        }
    }
}