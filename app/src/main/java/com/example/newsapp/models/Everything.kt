package com.example.newsapp.models

import com.google.gson.annotations.SerializedName

data class Everything(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("content")
    val content: String
)

data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("country")
    val country: String
)


