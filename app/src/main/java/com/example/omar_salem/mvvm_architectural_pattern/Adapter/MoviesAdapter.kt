package com.example.omar_salem.mvvm_architectural_pattern.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.example.omar_salem.mvvm_architectural_pattern.Model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.Model.MovieItemResponse
import com.example.omar_salem.mvvm_architectural_pattern.R
import kotlinx.android.synthetic.main.movie_card.view.*

/**
 * TODO: Add class header
 */
class MoviesAdapter( val mContext :Context , val moviesList: List<MovieDetail>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MoviesAdapter.MyViewHolder {
        val mView: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_card,parent)
return MyViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return  moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MyViewHolder, position: Int) {
        holder.tittle.text=moviesList[position].movieTitle
        holder.movieOverview.text=moviesList[position].movieOverview
        holder.userratting.text=moviesList[position].movieVoteAverage




    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tittle: TextView
        val movieOverview:TextView
        val userratting: TextView
        val movieposter: ImageView
        init {
            tittle=itemView.movie_name_tv
            movieOverview=itemView.movie_desc_tv
            movieposter=itemView.movie_image
            userratting=itemView.movie_rate_tv
        }
    }
}