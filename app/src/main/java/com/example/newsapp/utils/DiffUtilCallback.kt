package com.example.newsapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.models.Everything

 class DiffUtilCallback : DiffUtil.ItemCallback<Everything>() {
    override fun areItemsTheSame(
        oldItem: Everything,
        newItem: Everything
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: Everything,
        newItem: Everything
    ) = oldItem == newItem
}