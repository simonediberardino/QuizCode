package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic
import com.quiz.code.Utility
import kotlin.collections.ArrayList

class JavaMain : CustomActivity(){
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_main)
        super.onPageLoaded()

        addTopics()
    }

    private fun addTopics(){
        val topics: Array<Topic> = arrayOf(
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments(),
            JavaIntroduction(),
            JavaComments())

        topics.forEach{addTopic(it)}
    }

    private fun addTopic(topic: Topic){
        val parentLayoutId = R.id.java_main_layout
        val parentViewId = R.id.parent
        val layoutToAddId = R.layout.single_topic

        val inflater = LayoutInflater.from(this)
        val gallery: LinearLayout = findViewById(parentLayoutId)
        val view = inflater.inflate(layoutToAddId, gallery, false)

        val topicTitleTW = view.findViewById<TextView>(R.id.topic_title)
        val topicdescTW = view.findViewById<TextView>(R.id.topic_description)
        val topicBox = view.findViewById<View>(parentViewId)

        topicTitleTW.setText(topic.name)
        topicdescTW.setText(topic.description)
        topicBox.setOnClickListener { topic.start(this) }

        gallery.addView(view)
    }
}