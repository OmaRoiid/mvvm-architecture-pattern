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

import kotlinx.android.synthetic.main.movie_card.view.*

/**
 *@author Omar Salem
 * Created at  Mar 12, 2019
 */
class MoviesAdapter(private val mContext :Context, var mOnClickedItemListener: OnClickedItemListener, var moviesList: List<MovieDetail>  ) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val mView: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_card,parent,false)
        return MyViewHolder(mView,mOnClickedItemListener)
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

    inner class MyViewHolder(itemView: View,mOnClickedItemListener: OnClickedItemListener) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val movieItemTittle: TextView
        val movieItemOverview:TextView
        val movieItemRate:TextView
        val movieItemPoster: ImageView
        val mOnClickedItemListener:OnClickedItemListener
        init {
            movieItemTittle=itemView.cv_movie_name_tv
            movieItemOverview=itemView.cv_movie_desc_tv
            movieItemRate=itemView.cv_movie_rate_tv
            movieItemPoster=itemView.cv_movie_image
            this.mOnClickedItemListener=mOnClickedItemListener
            itemView.setOnClickListener(this)
        }
        override fun onClick(clickedView: View?) {
            mOnClickedItemListener.onItemClicked(adapterPosition)
        }
    }
}