package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic

private val TOPIC_COMMENTS_NAME = CustomActivity.lastContext?.getString(R.string.java_comments_name)
private val TOPIC_COMMENTS_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_comments_description)

class JavaComments : Topic(
    lastContext?.getString(R.string.java_comments_name),
    lastContext?.getString(R.string.java_comments_description),
    JavaIntroduction::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}