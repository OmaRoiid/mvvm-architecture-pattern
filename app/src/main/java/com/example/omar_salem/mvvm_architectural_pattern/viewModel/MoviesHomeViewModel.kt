package com.example.omar_salem.mvvm_architectural_pattern.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.omar_salem.mvvm_architectural_pattern.errorHandler.NetworkListener
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.model.MoviesDB.MovieDataBase
import com.example.omar_salem.mvvm_architectural_pattern.model.repository.MoviesRepository

/**
 *  @author Omar Salem
 * Created at  Oct 1, 2019
 * last modifying at Oct 6, 2019
 */
class MoviesHomeViewModel(application : Application) : AndroidViewModel(application)  {

     var movieRepo: MoviesRepository


    init {
        val movieDao = MovieDataBase.getDatabase(application).getMovieDao()
        movieRepo = MoviesRepository(movieDao)
    }
      fun insertIntoDB(listMovieDetail: List<MovieDetail>) {
        movieRepo.insertToDB(listMovieDetail)
    }
    fun getMoviesFromDB():LiveData<List<MovieDetail>>{
        return movieRepo.fetchMoviesFromDB()
    }

    fun getMoviesFromServer ( errorHandler: NetworkListener) :LiveData<List<MovieDetail>> {
        return movieRepo.fetchMovies(errorHandler)
    }
}