package com.example.topheadlines.model

data class TopHeadLines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)