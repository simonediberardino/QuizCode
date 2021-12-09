package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic

private val TOPIC_LOOPS_NAME = CustomActivity.lastContext?.getString(R.string.java_loops_name)
private val TOPIC_LOOPS_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_loops_description)

class JavaLoops : Topic(TOPIC_LOOPS_NAME, TOPIC_LOOPS_DESCRIPTION, JavaIntroduction::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}