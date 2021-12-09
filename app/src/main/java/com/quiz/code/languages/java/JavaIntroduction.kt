package com.quiz.code.languages.java

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.protectsoft.webviewcode.Codeview
import com.protectsoft.webviewcode.Settings
import com.quiz.code.CustomActivity
import com.quiz.code.R
import com.quiz.code.Topic
import com.quiz.code.Utility

private val TOPIC_SYNTAX_NAME = CustomActivity.lastContext?.getString(R.string.java_introduction_name)
private val TOPIC_SYNTAX_DESCRIPTION = CustomActivity.lastContext?.getString(R.string.java_introduction_description)

class JavaIntroduction : Topic(TOPIC_SYNTAX_NAME, TOPIC_SYNTAX_DESCRIPTION, JavaIntroduction::class.java) {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_introduction)

        initializePage()
        super.onPageLoaded()
    }

    fun initializePage(){
        val codeView = findViewById<WebView>(R.id.java_intro_cw)
        var codeString = "" +
                "class MyNewClass{\n" +
                "\tpublic static void main(String[] args){\n" +
                "\t\tSystem.out.println(\"Hello World\");\n" +
                "\t}\n" +
                "}"

        codeString = Utility.replaceTabsWithSpaces(codeString)

        Codeview.with(this)
            .withCode(codeString)
            .setStyle(Settings.WithStyle.DARKULA)
            .into(codeView)
    }
}