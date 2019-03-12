package com.example.omar_salem.mvvm_architectural_pattern.rest

import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * TODO: Add class header
 */
class RetrofitClient {
    private val BASE_URL = ApiUtils.BASE_URL
    var retrofit: Retrofit? = null
    val getRetrofitClient: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
}