package com.example.omar_salem.mvvm_architectural_pattern.model.repository



import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieItemResponse
import com.example.omar_salem.mvvm_architectural_pattern.rest.ApiServices
import com.example.omar_salem.mvvm_architectural_pattern.rest.RetrofitClient
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * TODO: Add class header
 * Repository  Class for Makeing Apis Calling
 * Rebo Class in MVVM Arch must return LiveDate After Api Call
 * Singletone Pattern
 */
class MoviesRepository  : ViewModel() {

//Fetch Data from API when app in online mode
    fun fetchMovies() :MutableLiveData<List<MovieDetail>> {
        val mRetrofit=RetrofitClient()
        var movieResponseLiveData : MutableLiveData<List<MovieDetail>> = MutableLiveData()
                 mRetrofit.
                 getRetrofitClient.
                 create(ApiServices::class.java).
        getPopulerMovies(ApiUtils.API_KEY).
                 enqueue(object : Callback<MovieItemResponse> {
                     override fun onResponse(call: Call<MovieItemResponse>, response: Response<MovieItemResponse>) {
                         //Send response.body  to MainActivityViewModel
                         if( response.isSuccessful) {
                             movieResponseLiveData.value=response.body()!!.results
                             Log.d("Response",response.code().toString())
                         }

                     }

                     override fun onFailure(call: Call<MovieItemResponse>, t: Throwable) {
                        //Show Error Msg in screen
                            Log.d("Error",t.message.toString())
                     }
                 })

return movieResponseLiveData
    }

    //TODO
    // Fetch Data from DB using RoomDB when app in Offline mode by using  fetchMoviesFromDB () method
}