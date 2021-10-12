package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.base.BaseDiffUtilCallback
import com.example.newsapp.databinding.ItemSourceBinding
import com.example.newsapp.models.Source

class SourcesAdapter :
    PagingDataAdapter<Source, SourcesAdapter.ViewHolder>(BaseDiffUtilCallback<Source>()) {
    private lateinit var binding: ItemSourceBinding

    inner class ViewHolder(private val binding: ItemSourceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Source) {
            with(binding) {
                name.text = data.name
                tvDateNews.text = data.category
                description.text = data.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}