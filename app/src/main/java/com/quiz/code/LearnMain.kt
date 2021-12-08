package com.quiz.code

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.quiz.code.languages.java.JavaMain
import java.util.*
import kotlin.collections.ArrayList

class LearnMain : CustomActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_main)
        super.onPageLoaded()
        addLanguage("Java", 0, JavaMain::class.java)
        addLanguage("JavaScript", 0, JavaMain::class.java)
    }

    fun addLanguage(languageNameStr: String, nLessons: Int, languagePage: Class<*>){
        val parentLayoutId = R.id.learn_main_layout
        val parentViewId = R.id.parent
        val layoutToAddId = R.layout.single_language

        val inflater = LayoutInflater.from(this)
        val gallery: LinearLayout = findViewById(parentLayoutId)
        val view = inflater.inflate(layoutToAddId, gallery, false)
        val parentView = view.findViewById<ViewGroup>(parentViewId)

        val languageBox = view.findViewById<ConstraintLayout>(R.id.language_box)
        val languageNameView = view.findViewById<TextView>(R.id.language_Name)
        val languageIconView = view.findViewById<ImageView>(R.id.language_Icon)
        val languageLessView = view.findViewById<TextView>(R.id.language_nLessons)

        val languageId = resources.getIdentifier("language_icon_${languageNameStr.lowercase(Locale.getDefault())}", "drawable", packageName)

        languageNameView.setText(languageNameStr)
        languageIconView.setBackgroundResource(languageId)
        languageLessView.setText(getString(R.string.n_lessons).replace("{n_lessons}", nLessons.toString()))
        languageBox.setOnClickListener {Utility.navigateTo(this, languagePage)}

        languagePage.getMethod("topics").run {  }

        Utility.ridimensionamento(this, parentView)
        gallery.addView(view)
    }
}