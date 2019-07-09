package com.example.omar_salem.mvvm_architectural_pattern.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.R
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import com.willy.ratingbar.ScaleRatingBar
import kotlinx.android.synthetic.main.movie_card.view.*

/**
 * TODO: Add class header
 */
class MoviesAdapter( val mContext :Context ,var moviesList: List<MovieDetail> ) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val mView: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_card,parent,false)
        return MyViewHolder(mView)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.movieItemTittle.text=moviesList[position].movieTitle
        holder.movieItemOverview.text=moviesList[position].movieOverview
        holder.movieItemRate.text= java.lang.Double.parseDouble(moviesList[position].movieVoteAverage.toString()).toString()
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500"+moviesList[position].moviePoster )
                .placeholder(R.drawable.loading)
                .into(holder.movieItemPoster)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieItemTittle: TextView
        val movieItemOverview:TextView
        val movieItemRate:TextView
        var movieItemRateBar: ScaleRatingBar
        val movieItemPoster: ImageView
        init {
            movieItemTittle=itemView.findViewById(R.id.cv_movie_name_tv)
            movieItemOverview=itemView.findViewById(R.id.cv_movie_desc_tv)
            movieItemRate=itemView.findViewById(R.id.cv_movie_rate_tv)
            movieItemPoster=itemView.findViewById(R.id.cv_movie_image)
            movieItemRateBar= ScaleRatingBar(mContext)
        }
    }
}