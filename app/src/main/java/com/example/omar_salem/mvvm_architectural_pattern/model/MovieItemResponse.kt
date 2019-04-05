package com.example.omar_salem.mvvm_architectural_pattern.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

/**
 * TODO: Add class header
 */
data class MovieItemResponse(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: MutableLiveData<List<MovieDetail>>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int
)