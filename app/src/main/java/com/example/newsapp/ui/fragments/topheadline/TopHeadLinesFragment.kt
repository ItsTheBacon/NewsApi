package com.example.newsapp.ui.fragments.topheadline

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentTopHeadLinesBinding
import com.example.newsapp.models.Everything
import com.example.newsapp.ui.adapters.TopHeadLinesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadLinesFragment :
    BaseFragment<TopHeadLinesViewModel, FragmentTopHeadLinesBinding>(R.layout.fragment_top_head_lines) {
    override val binding by viewBinding(FragmentTopHeadLinesBinding::bind)
    override val viewModel: TopHeadLinesViewModel by viewModels()
    private val adapter: TopHeadLinesAdapter = TopHeadLinesAdapter()

    override fun initialize() {
        binding.rvTask.adapter = adapter

        viewModel.fetchTopHeadLines()

    }

    override fun setupObserve() {
        viewModel.topHeadLines.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

}