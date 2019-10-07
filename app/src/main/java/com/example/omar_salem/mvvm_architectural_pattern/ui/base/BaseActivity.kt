package com.example.omar_salem.mvvm_architectural_pattern.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * TODO: Add class header
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResourceId())

    }

    protected abstract fun getLayoutResourceId(): Int

}
