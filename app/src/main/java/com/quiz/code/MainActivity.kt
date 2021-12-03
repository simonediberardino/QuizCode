package com.quiz.code

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : CustomActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.onPageLoaded()

        setListeners()
    }

    fun setListeners(){
        val btn_learn_now = findViewById<Button>(R.id.main_learn)
        btn_learn_now.setOnClickListener { Utility.navigateTo(this, LearnMain::class.java) }
    }
}