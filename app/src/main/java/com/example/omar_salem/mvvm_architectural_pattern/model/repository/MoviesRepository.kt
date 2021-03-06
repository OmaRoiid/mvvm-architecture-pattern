package com.example.omar_salem.mvvm_architectural_pattern.model.repository



import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.omar_salem.mvvm_architectural_pattern.errorHandler.NetworkListener
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieItemResponse
import com.example.omar_salem.mvvm_architectural_pattern.model.MoviesDB.MovieDao
import com.example.omar_salem.mvvm_architectural_pattern.rest.ApiServices
import com.example.omar_salem.mvvm_architectural_pattern.rest.RetrofitClient
import com.example.omar_salem.mvvm_architectural_pattern.util.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Omar Salem
 * Created at  Mar 12, 2019
 * last modifying at Nov 17 , 2019
 * Repository  Class for Any logic Work
 * Singletone Pattern
 */
class MoviesRepository(private val mMovieDao: MovieDao)  {

//Fetch Data from API when app in online mode
    private lateinit var mErrorHandler:NetworkListener
    //get all Movies in DB
    private val allMovies: LiveData<List<MovieDetail>> = mMovieDao.getSavedMovies()

    fun fetchMovies( errorHandler: NetworkListener ) :MutableLiveData<List<MovieDetail>> {
       this.mErrorHandler=errorHandler
        val mRetrofit=RetrofitClient()
        var movieResponseLiveData : MutableLiveData<List<MovieDetail>> = MutableLiveData()
                 mRetrofit.
                 getRetrofitClient.
                 create(ApiServices::class.java).
                 getPopulerMovies(ApiUtils.API_KEY).
                 enqueue(object : Callback<MovieItemResponse> {
                     override fun onResponse(call: Call<MovieItemResponse>, response: Response<MovieItemResponse>) {
                         //Send response.body  to MainActivityViewModel
                         if( response.isSuccessful && response.code()==200) {
                             movieResponseLiveData.value=response.body()!!.results
                         }
                         if(response.code()!=200) {
                             errorHandler.onParsingError( parsingErrFlag = false)
                         }
                     }

                     override fun onFailure(call: Call<MovieItemResponse>, t: Throwable) {
                            //No need  for this  function because Offline Mode

                     }
                 })

     return movieResponseLiveData
    }

    fun insertToDB(movieDetail: List<MovieDetail>)  {

           class SaveMoviesListIntoDatabase  : AsyncTask<List<MovieDetail>, Void, Void>(){
               override fun doInBackground(vararg p0: List<MovieDetail>?): Void? {
                   if (movieDetail.isEmpty()) return null
                   mMovieDao.saveParsedMoviesIntoDatabase(movieDetail)
                   return null
               }
           }
           SaveMoviesListIntoDatabase().execute()
    }
    //return All data in DB  in offline mode  to display on the  screen
    fun fetchMoviesFromDB() : LiveData<List<MovieDetail>>
    {
        return allMovies
    }





}