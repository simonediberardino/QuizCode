package com.quiz.code

abstract class LanguageActivity : CustomActivity(){
    abstract val topics: Array<Topic>

    fun getRandomTopic(): Topic {
        return topics.random()
    }
}