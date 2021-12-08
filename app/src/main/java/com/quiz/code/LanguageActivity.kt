package com.quiz.code

import com.quiz.code.languages.java.*

abstract class LanguageActivity : CustomActivity(){
    abstract fun topics(): Array<Topic>

}