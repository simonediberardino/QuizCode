package com.quiz.code

import com.quiz.code.languages.java.JavaMain


data class Languages(val name: String, val languageClass: Class<*>){
    companion object{
        val languages = arrayOf(
            Languages("Java", JavaMain::class.java),
            Languages("JavaScript", JavaMain::class.java)
        )
    }
}
