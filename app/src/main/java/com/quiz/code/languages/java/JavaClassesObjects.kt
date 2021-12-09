package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic

private val TOPIC_CLOB_NAME = CustomActivity.lastContext?.getString(R.string.java_clob_name)
private val TOPIC_CLOB_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_clob_description)

class JavaClassesObjects : Topic(TOPIC_CLOB_NAME, TOPIC_CLOB_DESCRIPTION, JavaIntroduction::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}