package com.quiz.code

abstract class QuizQuestion {
    abstract val question: String

    abstract fun showQuestion()
    abstract fun checkAnswer(answer: Any)
    abstract fun onAnswerCorrect(answer: Any)
    abstract fun onAnswerWrong(answer: Any)
}