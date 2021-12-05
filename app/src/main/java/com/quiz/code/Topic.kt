package com.quiz.code

open class Topic(var name: String?, var description: String?, var activity: Class<*>) : CustomActivity() {
    fun start(curActivity: CustomActivity) = Utility.navigateTo(curActivity, activity)
}