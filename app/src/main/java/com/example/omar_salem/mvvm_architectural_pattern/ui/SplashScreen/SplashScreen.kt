package com.example.omar_salem.mvvm_architectural_pattern.ui.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.omar_salem.mvvm_architectural_pattern.ui.HomeScreen.MoviesHomeActivity
import com.example.omar_salem.mvvm_architectural_pattern.R

class SplashScreen : AppCompatActivity() {
    var startMainActivity:Intent?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)
        Handler().postDelayed({
         startMainActivity= Intent(this@SplashScreen, MoviesHomeActivity::class.java)
            this@SplashScreen.startActivity(startMainActivity)
            finish()
        }, 3000)
    }


}
