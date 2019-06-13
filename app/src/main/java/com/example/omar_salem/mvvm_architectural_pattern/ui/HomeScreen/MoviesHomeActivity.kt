package com.example.omar_salem.mvvm_architectural_pattern.ui.HomeScreen

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.omar_salem.mvvm_architectural_pattern.adapters.MoviesAdapter
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.R
import com.example.omar_salem.mvvm_architectural_pattern.viewModel.MoviesHomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MoviesHomeActivity : AppCompatActivity() {
    lateinit var mMoviesHomeViewModel:MoviesHomeViewModel
    lateinit var mMovieAdapter :  MoviesAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init the ViewModel Obj
        setUpRecyclerView()
        mMoviesHomeViewModel = ViewModelProviders.of(this).get(MoviesHomeViewModel::class.java)
        mMoviesHomeViewModel.initMoviesHomeViewModel()
        mMoviesHomeViewModel.getMoviesFromRepositry().observe(this, Observer <List<MovieDetail>>{observedList->
            mMovieAdapter= MoviesAdapter(this@MoviesHomeActivity,observedList)
            mMovieAdapter.notifyDataSetChanged()
            rv_movies_list.adapter = mMovieAdapter
        })


    }
   private fun setUpRecyclerView()
    {

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)

    }


}
