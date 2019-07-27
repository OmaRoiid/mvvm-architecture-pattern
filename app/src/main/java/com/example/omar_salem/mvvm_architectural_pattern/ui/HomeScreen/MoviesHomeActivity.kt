package com.example.omar_salem.mvvm_architectural_pattern.ui.HomeScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.omar_salem.mvvm_architectural_pattern.adapters.MoviesAdapter
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.R
import com.example.omar_salem.mvvm_architectural_pattern.adapters.OnClickedItemListener
import com.example.omar_salem.mvvm_architectural_pattern.ui.DetailScreen.DetailScreenActivity
import com.example.omar_salem.mvvm_architectural_pattern.viewModel.MoviesHomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.example.omar_salem.mvvm_architectural_pattern.util.NetworkUtils
import org.parceler.Parcels


class MoviesHomeActivity : AppCompatActivity() , OnClickedItemListener {
    lateinit var mMoviesHomeViewModel: MoviesHomeViewModel
    lateinit var mMovieAdapter: MoviesAdapter
     var checkNetworkConnection:NetworkUtils =NetworkUtils()
    lateinit var mOnClickedItemListener :OnClickedItemListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(!checkNetworkConnection.isNetworkAvailable(this@MoviesHomeActivity))
        {
          checkNetworkConnection.openNetworkSittingsScreen(this@MoviesHomeActivity)
        }
        setUpRecyclerView()
        //init the ViewModel Obj
        mMoviesHomeViewModel = ViewModelProviders.of(this).get(MoviesHomeViewModel::class.java)
        mMoviesHomeViewModel.initMoviesHomeViewModel()
        mMoviesHomeViewModel.getMoviesFromRepositry().observe(this, Observer<List<MovieDetail>> { observedList ->
            mMovieAdapter = MoviesAdapter(this@MoviesHomeActivity,this ,observedList)
            mMovieAdapter.notifyDataSetChanged()
            rv_movies_list.adapter = mMovieAdapter
        })
    }
    private fun setUpRecyclerView() {
        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
    }
    override fun onResume() {
        super.onResume()
        mMoviesHomeViewModel.getMoviesFromRepositry().observe(this, Observer<List<MovieDetail>> { observedList ->
            mMovieAdapter = MoviesAdapter(this@MoviesHomeActivity,this ,observedList)
            mMovieAdapter.notifyDataSetChanged()
            rv_movies_list.adapter = mMovieAdapter
        })
    }
//Using Parceler Lib to passing Clicked Movie Obj to Detail Activity , More details please visit  this link --> https://github.com/johncarl81/parceler
    override fun OnItemClicked(position: Int) {
        val onMovieClicked :MovieDetail = mMovieAdapter.moviesList[position]
        val sendingObjToDetailActivity=Intent(this,DetailScreenActivity::class.java)
        sendingObjToDetailActivity.putExtra("clickedMovie", Parcels.wrap(onMovieClicked))
        startActivity(sendingObjToDetailActivity)
    }
}

