package com.example.omar_salem.mvvm_architectural_pattern.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

/**
 * @author Omar Salem
 * this class for  each  movie detail and we can have  more  detail about movie by adding  another attributes
 */
//To Avoid  an error of  kotlin data  class  that cus it's getter/setters were private
// see the  solving of this  problem --> https://stackoverflow.com/questions/33891814/use-of-parceler-with-kotlin-data-class-with-constructor-for-serialization
@Parcel  (Parcel.Serialization.BEAN)
data class MovieDetail @ParcelConstructor constructor(
        @SerializedName("poster_path")
        val  moviePoster :String,
        @SerializedName("title")
        val movieTitle:String ,
        @SerializedName("overview")
        val movieOverview :String ,
        @SerializedName("vote_average")
        val movieVoteAverage : Double ,
        @SerializedName("id")
        val movieID : Int ,
        @SerializedName ("release_date")
        val releaseDate :String
)