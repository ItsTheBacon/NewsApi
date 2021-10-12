package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.base.BaseDiffUtilCallback
import com.example.newsapp.databinding.ItemEverythingBinding
import com.example.newsapp.models.Everything
import com.example.newsapp.utils.dateFormat

class EverythingAdapter : PagingDataAdapter<Everything, EverythingAdapter.ViewHolder>(
    BaseDiffUtilCallback<Everything>()
) {
    private lateinit var binding: ItemEverythingBinding

    inner class ViewHolder(
        private val binding: ItemEverythingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Everything) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.urlToImage)
                    .centerCrop()
                    .into(imgNews)
                tvTitleNews.text = data.title
                tvDateNews.text = "${dateFormat(data.publishedAt)}"
                tvContentNews.text = data.content
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemEverythingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

}