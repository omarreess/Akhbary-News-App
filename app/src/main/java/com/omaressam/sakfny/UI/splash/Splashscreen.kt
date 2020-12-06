package com.omaressam.sakfny.UI.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.omaressam.sakfny.MainActivity
import com.omaressam.sakfny.R

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity


            startActivity(Intent(applicationContext, MainActivity::class.java))



        }, 2500)
    }
}