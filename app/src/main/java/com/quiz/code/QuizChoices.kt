package com.quiz.code

import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi

class QuizChoices(override val question: String, private val answers: Array<String>, override val topic: Class<*>) : QuizQuestion() {
    companion object {
        const val N_OPTIONS = 4
    }

    override val type: Class<QuizQuestion> get() = this.javaClass

    @RequiresApi(Build.VERSION_CODES.M)
    override fun showQuestion(layout: ViewGroup) {
        val titleTW = layout.findViewById<TextView>(R.id.quiz_mo_title)
        val questionTW = layout.findViewById<TextView>(R.id.quiz_mo_question)
        val questions = ArrayList<TextView>()

        titleTW.text = super.getTopicTitle()
        questionTW.text = this.question

        val rightAnswer = answers[0]
        val shuffledAnswers = answers.copyOf()
        shuffledAnswers.shuffle()

        for(answerI in 0 until N_OPTIONS){
            val resID = layout.resources.getIdentifier("quiz_mo_option_${answerI+1}", "id", CustomActivity.lastContext?.packageName)
            val answerBTN = layout.findViewById<TextView>(resID)

            answerBTN.text = shuffledAnswers[answerI]
            answerBTN.setOnClickListener{ this.checkAnswer(rightAnswer, answerBTN) }

            questions.add(answerBTN)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun checkAnswer(correctAnswer: Any, givenAnswer: Any) {
        val givenAnswerString = (givenAnswer as TextView).text.toString()

        if(correctAnswer == givenAnswerString){
            this.onAnswerCorrect(givenAnswer)
        }else{
            this.onAnswerWrong(givenAnswer)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onAnswerWrong(answer: Any?) {
        super.onAnswerWrong(answer)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onAnswerCorrect(answer: Any?) {
        super.onAnswerCorrect(answer)
    }
}