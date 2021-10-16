package com.example.newsapp.ui.fragments.sources

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSourcesBinding
import com.example.newsapp.ui.adapters.SourcesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<SourcesViewModel, FragmentSourcesBinding>(R.layout.fragment_sources) {
    override val binding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()
    private val adapter: SourcesAdapter = SourcesAdapter()
    override fun initialize() {
        binding.rvTask.adapter = adapter
    }

    override fun setupViews() {
        adapter.addLoadStateListener {
            binding.progressBarEverything.isVisible = it.refresh is LoadState.Loading
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchSource().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}