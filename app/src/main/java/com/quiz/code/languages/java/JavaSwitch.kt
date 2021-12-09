package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic

private val TOPIC_SWITCH_NAME = CustomActivity.lastContext?.getString(R.string.java_switch_name)
private val TOPIC_SWITCH_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_switch_description)

class JavaSwitch : Topic(TOPIC_SWITCH_NAME, TOPIC_SWITCH_DESCRIPTION, JavaIntroduction::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)
        super.onPageLoaded()
    }
}