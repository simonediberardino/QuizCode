package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic

class JavaIfElse : Topic(
    lastContext?.getString(R.string.java_ifelse_name),
    lastContext?.getString(R.string.java_ifelse_description),
    JavaIntroduction::class.java) {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}