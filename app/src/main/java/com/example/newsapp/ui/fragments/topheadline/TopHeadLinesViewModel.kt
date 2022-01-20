package com.example.newsapp.ui.fragments.topheadline

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapp.base.BaseViewModel
import com.example.newsapp.data.repositories.TopHeadLinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadLinesViewModel @Inject constructor(
    private val repository: TopHeadLinesRepository
) : BaseViewModel() {
    fun fetchTopHeadLines() = repository.fetchTopHeadLines().cachedIn(viewModelScope)
}