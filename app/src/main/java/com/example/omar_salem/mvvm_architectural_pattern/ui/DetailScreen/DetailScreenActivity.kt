package com.example.omar_salem.mvvm_architectural_pattern.ui.DetailScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.omar_salem.mvvm_architectural_pattern.R
import com.example.omar_salem.mvvm_architectural_pattern.R.layout.activity_detail_screen
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import kotlinx.android.synthetic.main.details_screen.*
import org.parceler.Parcels

class DetailScreenActivity : AppCompatActivity() {
    lateinit var currentMovie : MovieDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_detail_screen)
        supportActionBar!!.hide()
        displayClickedMovieOnScreen()

    }
  private fun displayClickedMovieOnScreen()
    {
        currentMovie= Parcels.unwrap(this.intent.getParcelableExtra("clickedMovie"))
        TV_name_of_SelectedMovie.text= currentMovie.movieTitle
        TV_user_rate.text=currentMovie.movieVoteAverage.toString()
        TV_release_date.text=currentMovie.releaseDate
        Tv_Descraption_of_slected_movie.text=currentMovie.movieOverview
        Glide.with(this@DetailScreenActivity)
                .load("https://image.tmdb.org/t/p/w500"+currentMovie.moviePoster)
                .placeholder(R.drawable.loading)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .onlyRetrieveFromCache(true)
                .into(IV_selectedMovie)
    }
}
