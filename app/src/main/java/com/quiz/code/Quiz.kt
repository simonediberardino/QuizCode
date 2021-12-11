package com.quiz.code

abstract class QuizQuestion(question: String){
    abstract fun showQuestion()
    abstract fun onAnswerCorrect()
    abstract fun onAnswerWrong()
}