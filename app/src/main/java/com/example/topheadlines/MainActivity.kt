package com.example.topheadlines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topheadlines.adapter.TopHeadLinesAdapter
import com.example.topheadlines.api.TopHeadLinesApi
import com.example.topheadlines.model.Article
import com.example.topheadlines.model.TopHeadLines
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()
    }

    fun getNews(){

        var BASE_URL = "http://newsapi.org/v2/"

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(TopHeadLinesApi::class.java)

        var apiCall = retrofitService.getNews("us",
            "business",
            "abde576eac1749d2bddc6287822cbb14")

        apiCall.enqueue(object : Callback<TopHeadLines>{

            override fun onFailure(call: Call<TopHeadLines>, t: Throwable) {
                Log.d("Failure", t.toString())
            }

            override fun onResponse(call: Call<TopHeadLines>, response: Response<TopHeadLines>) {

                var News = response.body()?.articles
                Log.d("Response>>>>>",News.toString())

                var topHeadLinesAdapter = News?.let { TopHeadLinesAdapter(it) }
                recyclerTopHeadLines.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = topHeadLinesAdapter
                }

            }

        })

    }
}
