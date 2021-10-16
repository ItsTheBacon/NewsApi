package com.example.newsapp.ui.fragments.everything

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentEverythingBinding
import com.example.newsapp.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<EveryThingViewModel, FragmentEverythingBinding>(R.layout.fragment_everything) {
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EveryThingViewModel by viewModels()
    private val adapter: EverythingAdapter = EverythingAdapter()

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
            viewModel.fetchEverything().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}

