package com.example.omar_salem.mvvm_architectural_pattern.Model

import com.google.gson.annotations.SerializedName

/**
 * @author Omar Salem
 * this class for  each  movie detail and we can have  more  detail about movie by adding  another attributes
 */
data class MovieDetail (
        @SerializedName("poster_path ")
        val  moviePoster :String,
        @SerializedName("title")
        val movieTitle:String ,
        @SerializedName("overview")
        val movieOverview :String ,
        @SerializedName("vote_average")
        val movieVoteAverage : String
)