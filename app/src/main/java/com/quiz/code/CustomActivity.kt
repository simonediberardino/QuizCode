package com.quiz.code

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

open class CustomActivity : AppCompatActivity() {
    companion object {
        var lastContext: CustomActivity? = null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Utility.enableTopBar(this)
        lastContext = this
    }

    fun onPageLoaded(){
        Utility.ridimensionamento(this, findViewById(R.id.parent))
    }

}