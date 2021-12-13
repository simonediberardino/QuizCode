package com.quiz.code

class QuizChoices(override val question: String, private val answers: Array<String>, private val indexRightAnswer: Int) : QuizQuestion() {
    override fun showQuestion() {
        TODO("Not yet implemented")
    }

    override fun checkAnswer(answer: Any) {
        val answerIndex = answer as Int
        if(answerIndex == indexRightAnswer){
            this.onAnswerCorrect(answer)
        }else{
            this.onAnswerWrong(answer)
        }
    }

    override fun onAnswerWrong(answer: Any) {
        TODO("Not yet implemented")
    }

    override fun onAnswerCorrect(answer: Any) {
        TODO("Not yet implemented")
    }
}