package com.example.newsapp.ui.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.newsapp.base.BaseDiffUtilCallback
import com.example.newsapp.databinding.ItemEverythingBinding
import com.example.newsapp.models.Everything
import com.example.newsapp.utils.dateFormat

class TopHeadLinesAdapter :
    PagingDataAdapter<Everything, TopHeadLinesAdapter.ViewHolder>(BaseDiffUtilCallback<Everything>()) {
    private lateinit var binding: ItemEverythingBinding


    inner class ViewHolder(private val binding: ItemEverythingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Everything) {
            with(binding) {
                Glide.with(imgNews)
                    .load(data.urlToImage)
                    .listener(object : RequestListener<Drawable?> {
                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            dataSource: com.bumptech.glide.load.DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            itemProgressBar.visibility = View.GONE
                            return false
                        }

                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            itemProgressBar.visibility = View.GONE
                            return false
                        }
                    })
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imgNews)

                tvTitleNews.text = data.title
                tvDateNews.text = "${dateFormat(data.publishedAt)}"
                tvContentNews.text = data.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemEverythingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}


