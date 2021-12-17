package com.quiz.code

import android.os.Build
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi

class QuizChoices(override val question: String, private val answers: Array<String>, private val indexRightAnswer: Int, override val topic: Class<*>) : QuizQuestion() {
    companion object{
        const val N_OPTIONS = 4
    }
    override val type: Class<QuizQuestion> get() = this.javaClass

    @RequiresApi(Build.VERSION_CODES.M)
    override fun showQuestion(layout: ViewGroup) {
        val questionTW = layout.findViewById<TextView>(R.id.quiz_mo_question)
        val questions = ArrayList<TextView>()

        questionTW.text = this.question

        for(answerI in 0 until N_OPTIONS){
            val resID = layout.resources.getIdentifier("quiz_mo_option_${answerI+1}", "id", CustomActivity.lastContext?.packageName)
            val answerBTN = layout.findViewById<TextView>(resID)

            answerBTN.text = answers[answerI]
            answerBTN.setOnClickListener{ this.checkAnswer(answerI) }
            questions.add(answerBTN)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun checkAnswer(answer: Any) {
        val answerIndex = answer as Int
        if(answerIndex == indexRightAnswer){
            this.onAnswerCorrect(answer)
        }else{
            this.onAnswerWrong(answer)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onAnswerWrong(answer: Any?) {
        super.onAnswerWrong(answer)
        println("Wrong answer!")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onAnswerCorrect(answer: Any?) {
        super.onAnswerCorrect(answer)
        println("Correct answer!")
    }
}