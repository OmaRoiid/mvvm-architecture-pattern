package com.example.omar_salem.mvvm_architectural_pattern.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.model.repository.MoviesRepository

/**
 * TODO: Add class header
 */
class MoviesHomeViewModel : ViewModel() {
    lateinit var movieLiveData : MutableLiveData<List<MovieDetail>>
    lateinit var movieRebo: MoviesRepository

fun initMoviesHomeViewModel ()
{
    movieRebo= MoviesRepository()
    movieLiveData=movieRebo.fetchMovies()
}



    fun getMoviesFromRepositry () :LiveData<List<MovieDetail>> {

        return movieRebo.fetchMovies()
    }
}