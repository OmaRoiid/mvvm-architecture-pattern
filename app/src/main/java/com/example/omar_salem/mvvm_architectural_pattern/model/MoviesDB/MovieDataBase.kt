package com.example.omar_salem.mvvm_architectural_pattern.model.MoviesDB

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail

/**
 * @author Omar Salem
 * Created at  Oct 1, 2019
 * last modifying at Oct 6, 2019
 * In this  class  if  you want  to update  your  DB  Schema  you can made  it  by Update the  version
 * using migration
 * for  more  info check this  link : https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
 *  Singleton prevents multiple instances of database opening at the
 */
@Database( entities = [MovieDetail::class],version = 1)
 abstract  class MovieDataBase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao



    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase? = null

        fun getDatabase(context: Context): MovieDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDataBase::class.java,
                        "movies_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}