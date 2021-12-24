package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import com.quiz.code.CustomPagerAdapter
import com.quiz.code.R
import com.quiz.code.Topic

class JavaCasting : Topic(
    lastContext?.getString(R.string.java_casting_name),
    lastContext?.getString(R.string.java_casting_description),
    JavaCasting::class.java) {

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