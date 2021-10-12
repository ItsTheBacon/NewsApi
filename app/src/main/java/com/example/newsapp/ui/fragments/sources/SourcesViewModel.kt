package com.example.newsapp.ui.fragments.sources

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.repositories.TopHeadLinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(private val repository: TopHeadLinesRepository) :
    BaseViewModel() {
    fun fetchSource() = repository.fetchSource().cachedIn(viewModelScope)
}