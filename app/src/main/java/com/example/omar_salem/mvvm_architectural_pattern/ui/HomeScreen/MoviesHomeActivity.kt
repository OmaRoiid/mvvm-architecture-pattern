package com.example.omar_salem.mvvm_architectural_pattern.ui.HomeScreen

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init the ViewModel Obj
        mMoviesHomeViewModel = ViewModelProviders.of(this).get(MoviesHomeViewModel::class.java)
        mMoviesHomeViewModel.initMoviesHomeViewModel()
        mMoviesHomeViewModel.getMoviesFromRepositry().observe(this, Observer <List<MovieDetail>>{movies ->
            //update Rcyc Adapter
            rv_movies_list.adapter= MoviesAdapter(this,movies)

        })
        //init RecyclerView
        setUpRecyclerView()


    }
    fun setUpRecyclerView()
    {
        rv_movies_list.setHasFixedSize(true)
        rv_movies_list.layoutManager = LinearLayoutManager(this)
    }

}
