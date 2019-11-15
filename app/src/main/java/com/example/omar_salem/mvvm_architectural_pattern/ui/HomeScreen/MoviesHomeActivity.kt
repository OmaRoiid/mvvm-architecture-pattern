package com.example.omar_salem.mvvm_architectural_pattern.ui.HomeScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import com.example.omar_salem.mvvm_architectural_pattern.adapters.MoviesAdapter
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail
import com.example.omar_salem.mvvm_architectural_pattern.R
import com.example.omar_salem.mvvm_architectural_pattern.adapters.OnClickedItemListener
import com.example.omar_salem.mvvm_architectural_pattern.ui.base.BaseActivity
import com.example.omar_salem.mvvm_architectural_pattern.ui.DetailScreen.DetailScreenActivity
import com.example.omar_salem.mvvm_architectural_pattern.viewModel.MoviesHomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels
import com.example.omar_salem.mvvm_architectural_pattern.callbacks.NetworkListener
import android.net.ConnectivityManager
import android.content.Context
import androidx.lifecycle.ViewModelProvider

/**
 * @author Omar Salem
 * Created at  Mar 12, 2019
 * last modifying at Oct 6, 2019
 * This Class is only responsible for Drawing the  UI  of  the  App
 * Common issues:
 * 1-making any logical in main screen like  Build ur  RoomDB this breaks the principles of MVVM Arch
 *
 */
 class MoviesHomeActivity : BaseActivity(), OnClickedItemListener,NetworkListener {
    private lateinit var mMoviesHomeViewModel: MoviesHomeViewModel
    private lateinit var mMovieAdapter: MoviesAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpRecyclerView()
        //init the ViewModel Obj
        mMoviesHomeViewModel = ViewModelProvider(this@MoviesHomeActivity).get(MoviesHomeViewModel::class.java)
        fetchMoviesFromServerOrDB(isNetworkAvailable())

    }

    private fun setUpRecyclerView() {
        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
    }

    /*
    * Using Parceler Lib to passing Clicked Movie Obj to Detail Activity
    * More details please visit  this link --> https://github.com/johncarl81/parceler
    * */
    override fun onItemClicked(position: Int) {
        val onMoviePositionClicked: MovieDetail = mMovieAdapter.moviesList[position]
        val sendingObjToDetailActivity = Intent(this, DetailScreenActivity::class.java)
        sendingObjToDetailActivity.putExtra("clickedMovie", Parcels.wrap(onMoviePositionClicked))
        startActivity(sendingObjToDetailActivity)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun onParsingError(parsingErrMsg: String) {
        Toast.makeText(this@MoviesHomeActivity, parsingErrMsg, Toast.LENGTH_LONG).show()
    }

    /*
     * check your network connection  to retrieve data from server or from DataBase
     */
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private fun fetchMoviesFromServerOrDB(flag: Boolean) {

        if (flag) {

            mMoviesHomeViewModel.getMoviesFromServer(this).observe(this, Observer<List<MovieDetail>> { observedList ->
                mMovieAdapter = MoviesAdapter(this@MoviesHomeActivity, this, observedList)
                mMovieAdapter.notifyDataSetChanged( )
                rv_movies_list.adapter = mMovieAdapter
                //Insert the Observedlist Into Room DataBase
                mMoviesHomeViewModel.insertIntoDB(observedList)

            })

        } else {
            mMoviesHomeViewModel.getMoviesFromDB().observe(this, Observer<List<MovieDetail>> {
                mMovieAdapter = MoviesAdapter(this@MoviesHomeActivity, this, it)
                mMovieAdapter.notifyDataSetChanged()
                rv_movies_list.adapter = mMovieAdapter

            })

            Toast.makeText(this@MoviesHomeActivity, "Offline Mode ", Toast.LENGTH_LONG).show()

        }

    }





}

