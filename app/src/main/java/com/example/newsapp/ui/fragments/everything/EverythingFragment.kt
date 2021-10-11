package com.example.newsapp.ui.fragments.everything

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentEverythingBinding
import com.example.newsapp.models.Everything
import com.example.newsapp.ui.adapters.TopHeadLinesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<EveryThingViewModel, FragmentEverythingBinding>(R.layout.fragment_everything) {
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EveryThingViewModel by viewModels()
    private val adapter:TopHeadLinesAdapter = TopHeadLinesAdapter()


    override fun initialize() {
        binding.rvTask.adapter = adapter

        viewModel.fetchEveryThing()

    }

    override fun setupObserve() {
        viewModel.everything.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

}

