package com.example.omar_salem.mvvm_architectural_pattern.callbacks

import androidx.lifecycle.MutableLiveData
import com.example.omar_salem.mvvm_architectural_pattern.model.MovieDetail

/**
 * @author Omar Salem
 * Created at  Mar 12, 2019
 * last modifying at Oct 6, 2019
 */
interface NetworkListener {
    fun onParsingError(parsingErrMsg:String)

}