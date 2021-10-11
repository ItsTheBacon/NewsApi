package com.example.newsapp.ui.fragments.everything

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.repositories.EverythingRepository
import com.example.newsapp.models.Everything
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.resouce.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EveryThingViewModel @Inject constructor(private val repository: EverythingRepository) :
    BaseViewModel() {
    val everything : MutableLiveData<List<Everything>> = MutableLiveData()
    fun fetchEveryThing() {
        viewModelScope.launch {
            repository.fetchEverything().collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("anime", "Loading: "  + it.data)

                    }
                    is Resource.Error -> {
                        Log.e("anime", "error: "  + it.message.toString())

                    }
                    is Resource.Success -> {
                        everything.postValue(it.data?.body()?.articles)
                        Log.d("anime", "Success: ${it.data?.body().toString()}")
                    }
                }
            }
        }
    }
}