package com.example.topheadlines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topheadlines.R
import com.example.topheadlines.model.Article
import com.example.topheadlines.model.TopHeadLines
import kotlinx.android.synthetic.main.top_headlines_item.view.*

class TopHeadLinesAdapter (var articleList: List<Article>): RecyclerView.Adapter<TopHeadLinesAdapter.topHeadLinesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): topHeadLinesViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.top_headlines_item, parent, false)
        return topHeadLinesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: topHeadLinesViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    inner class topHeadLinesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(article: Article){
            itemView.txtAuthor.text = article.author
            itemView.txtContent.text = article.content
        }
    }

}