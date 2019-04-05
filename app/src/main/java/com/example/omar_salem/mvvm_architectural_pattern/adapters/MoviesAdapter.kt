package com.example.omar_salem.mvvm_architectural_pattern.adapters

import android.content.Context
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
        holder.movieItemTittle.text=moviesList[position].movieTitle
        holder.movieItemOverview.text=moviesList[position].movieOverview
        holder.movieItemRate.text=moviesList[position].movieVoteAverage.toString()
        Glide.with(mContext)
        .load(moviesList[position].moviePoster + ApiUtils.BASE_IMAGE_URL).into(holder.movieItemPoster)



    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieItemTittle: TextView
        val movieItemOverview:TextView
        val movieItemRate: TextView
        val movieItemPoster: ImageView
        init {
            movieItemTittle=itemView.movie_name_tv
            movieItemOverview=itemView.movie_desc_tv
            movieItemPoster=itemView.movie_image
            movieItemRate=itemView.movie_rate_tv
        }
    }
}