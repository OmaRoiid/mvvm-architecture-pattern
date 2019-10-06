package com.example.omar_salem.mvvm_architectural_pattern.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

/**
 * @author Omar Salem
 * Created at  Mar 12, 2019
 * last modifying at Oct 6, 2019
 * this class for  each  movie detail and we can have  more  detail about movie by adding  another attributes
 */
//To Avoid  an error of  kotlin data  class  that cus it's getter/setters were private
// see the  solving of this  problem --> https://stackoverflow.com/questions/33891814/use-of-parceler-with-kotlin-data-class-with-constructor-for-serialization
@Entity(tableName = "movieDetail")
@Parcel  (Parcel.Serialization.BEAN)
data class MovieDetail @ParcelConstructor constructor(
        @SerializedName("poster_path")
        @NonNull
        @ColumnInfo(name = "Movie_Poster")
        val  moviePoster :String,
        @SerializedName("title")
        @NonNull
        @ColumnInfo(name = "Movie_Title")
        val movieTitle:String ,
        @SerializedName("overview")
        @NonNull
        @ColumnInfo(name = "Movie_Overview")
        val movieOverview :String ,
        @SerializedName("vote_average")
        @NonNull
        @ColumnInfo(name = "Movie_VoteAvarage")
        val movieVoteAverage : Double ,
        @SerializedName("id")
        @PrimaryKey(autoGenerate = false)
        @NonNull
        @ColumnInfo(name = "Movie_ID")
        val movieID : Int ,
        @SerializedName ("release_date")
        @NonNull
        @ColumnInfo(name = "Movie_Release")
        val releaseDate :String
)