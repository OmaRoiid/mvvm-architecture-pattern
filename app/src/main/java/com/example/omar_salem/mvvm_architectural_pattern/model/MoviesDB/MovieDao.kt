package com.example.omar_salem.mvvm_architectural_pattern.model.MoviesDB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail

/**
 * @author Omar Salem
 * Created at  Oct 1, 2019
 * last modifying at Oct 6, 2019
 *  DAO interface class responsible for all the transactions in Database
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveParsedMoviesIntoDatabase(movieDetail: List<MovieDetail>)

    @Query("select * from movieDetail")
    fun getSavedMovies() : LiveData<List<MovieDetail>>

    @Query("select * from movieDetail")
    fun getSavedMovies2() : List<MovieDetail>

}