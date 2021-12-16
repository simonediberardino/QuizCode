package com.quiz.code

import com.quiz.code.languages.java.JavaArray
import com.quiz.code.languages.java.JavaCasting

open class Topic(var name: String?, var description: String?, var activity: Class<*>) : CustomActivity() {
    fun start(curActivity: CustomActivity) = Utility.navigateTo(curActivity, activity)
}