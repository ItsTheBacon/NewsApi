package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemEverythingBinding
import com.example.newsapp.models.Everything
import com.example.newsapp.models.Source
import com.example.newsapp.utils.dateFormat

//class SourcesAdapter : PagingDataAdapter<Everything, SourcesAdapter.NewsViewHolder>(DiffCallback) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
//        return NewsViewHolder(ItemEverythingBinding.inflate(LayoutInflater.from(parent.context)))
//    }
//
//    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        val data = getItem(position)
//        holder.onBind(data)
//    }
//
//    class NewsViewHolder(private var binding: ItemEverythingBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun onBind(data: Everything?) {
//            with(binding) {
//                Glide.with(itemView.context)
//                    .load(data?.urlToImage)
//                    .centerCrop()
//                    .into(imgNews)
//                tvTitleNews.text = data?.title
//                tvDateNews.text = "${dateFormat(data?.publishedAt)}"
//                tvContentNews.text = data?.content
//            }
//        }
//    }
//
//    companion object DiffCallback : DiffUtil.ItemCallback<Everything>() {
//        override fun areItemsTheSame(oldItem: Everything, newItem: Everything): Boolean {
//            return oldItem == newItem
//        }
//        override fun areContentsTheSame(oldItem: Everything, newItem: Everything): Boolean {
//            return oldItem.source.id== newItem.source.id
//
//        }
//    }
//
//
//}