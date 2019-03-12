package com.example.omar_salem.mvvm_architectural_pattern.rest

import com.example.omar_salem.mvvm_architectural_pattern.Model.MovieItemResponse
import com.example.omar_salem.mvvm_architectural_pattern.Model.MoviesRepository
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * TODO: Add class header
 */
interface ApiServices {

@GET("movie/popular")
fun getPopulerMovies(@Query("api_key")  apiKey:String) :Call<MovieItemResponse>
}