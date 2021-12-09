package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.quiz.code.*


open class JavaMain : LanguageActivity(){
    override val topics: Array<Topic>
        get() = arrayOf(
            JavaIntroduction(),
            JavaComments(),
            JavaVarsAndDataTypes(),
            JavaCasting(),
            JavaStrings(),
            JavaIfElse(),
            JavaSwitch(),
            JavaLoops(),
            JavaArray(),
            JavaClassesObjects())

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_main)
        super.onPageLoaded()

        addTopics()
    }

    private fun addTopics(){
        topics.forEach{addTopic(it)}
    }

    private fun addTopic(topic: Topic){
        val parentLayoutId = R.id.topic_main_layout
        val parentViewId = R.id.parent
        val layoutToAddId = R.layout.single_topic

        val inflater = LayoutInflater.from(this)
        val gallery: LinearLayout = findViewById(parentLayoutId)
        val view = inflater.inflate(layoutToAddId, gallery, false)

        val topicTitleTW = view.findViewById<TextView>(R.id.topic_title)
        val topicdescTW = view.findViewById<TextView>(R.id.topic_description)
        val topicNTW = view.findViewById<TextView>(R.id.topic_n)
        val topicBox = view.findViewById<View>(parentViewId)

        val lessonNumber = gallery.childCount + 1

        topicTitleTW.setText(topic.name)
        topicdescTW.setText(topic.description)
        topicNTW.setText("$lessonNumber")

        topicBox.setOnClickListener { topic.start(this) }

        gallery.addView(view)
    }
}