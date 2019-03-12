package com.example.omar_salem.mvvm_architectural_pattern.Model


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.omar_salem.mvvm_architectural_pattern.rest.ApiServices
import com.example.omar_salem.mvvm_architectural_pattern.rest.RetrofitClient
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

/**
 * TODO: Add class header
 * Repository  Class for Makeing Apis Calling
 * Rebo Class in MVVM Arch must return LiveDate After Api Call
 */
class MoviesRepository {
    lateinit var mRetrofit:RetrofitClient
    fun fetchMovies() {

        val movieLiveData = MutableLiveData<MovieItemResponse>()
         mRetrofit.
                 getRetrofitClient.
                 create(ApiServices::class.java).
        getPopulerMovies(ApiUtils.API_KEY).
                 enqueue(object : Callback<MovieItemResponse> {
                     override fun onResponse(call: Call<MovieItemResponse>, response: Response<MovieItemResponse>) {
                         //Send response.body  to adapter

                     }

                     override fun onFailure(call: Call<MovieItemResponse>, t: Throwable) {
                        //Show Error Msg in screen
                     }
                 })







    }
}