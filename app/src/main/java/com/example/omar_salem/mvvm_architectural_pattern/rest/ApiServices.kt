package com.example.omar_salem.mvvm_architectural_pattern.rest

import com.example.omar_salem.mvvm_architectural_pattern.model.MovieItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO: Add class header
 */
interface ApiServices {

@GET("movie/popular")
fun getPopulerMovies(@Query("api_key")  apiKey:String) :Call<MovieItemResponse>
}