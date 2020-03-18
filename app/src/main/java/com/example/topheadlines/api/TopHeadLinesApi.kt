package com.example.topheadlines.api

import com.example.topheadlines.model.TopHeadLines
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadLinesApi {

    @GET("top-headlines")
    fun getNews(@Query("country") country: String,
                @Query("category") category:String,
                @Query("apiKey") api_key:String
        ): Call<TopHeadLines>
}