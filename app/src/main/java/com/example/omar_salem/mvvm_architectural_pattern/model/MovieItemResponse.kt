package com.example.omar_salem.mvvm_architectural_pattern.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

/**
 * @author Omar Salem
 * Created at  Mar 12, 2019
 */
data class MovieItemResponse(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: List<MovieDetail>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int
)