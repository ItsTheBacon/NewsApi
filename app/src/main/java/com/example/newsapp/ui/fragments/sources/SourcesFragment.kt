package com.example.newsapp.ui.fragments.sources

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapp.R
import com.example.newsapp.base.BaseFragment
import com.example.newsapp.databinding.FragmentSourcesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesFragment :
    BaseFragment<SourcesViewModel, FragmentSourcesBinding>(R.layout.fragment_sources) {
    override val binding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()


    override fun initialize() {
        viewModel.fetchSource()
//        viewModel.sources.observe(viewLifecycleOwner,{
//            binding.rvTask.adapter = SourcesAdapter(it as ArrayList<Source>)
//        })
    }
}