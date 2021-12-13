package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import com.quiz.code.CustomActivity
import com.quiz.code.CustomPagerAdapter
import com.quiz.code.R
import com.quiz.code.Topic

private val TOPIC_CASTING_NAME = CustomActivity.lastContext?.getString(R.string.java_casting_name)
private val TOPIC_CASTING_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_casting_description)

class JavaCasting : Topic(TOPIC_CASTING_NAME, TOPIC_CASTING_DESCRIPTION, JavaCasting::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_page)

        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        val nQuestions = 10
        viewPager.adapter = CustomPagerAdapter(this, arrayOf(JavaArray::class.java) as Array<Class<Topic>>, nQuestions)

        super.onPageLoaded()
    }
}