package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.R
import com.quiz.code.Topic

class JavaLoops : Topic(
    lastContext?.getString(R.string.java_loops_name),
    lastContext?.getString(R.string.java_loops_description),
    JavaIntroduction::class.java) {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}