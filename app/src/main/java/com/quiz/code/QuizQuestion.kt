package com.quiz.code

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import pl.droidsonroids.gif.GifImageView

abstract class QuizQuestion{
    abstract val question: String
    abstract val type: Class<*>
    abstract val topic: Class<*>

    abstract fun showQuestion(layout: ViewGroup)
    abstract fun checkAnswer(answer: Any)

    @RequiresApi(Build.VERSION_CODES.M)
    open fun onAnswerCorrect(answer: Any?){
        val dialog = Dialog(CustomActivity.lastContext!!)
        dialog.setContentView(R.layout.quiz_answer_summ)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogTitleTW = dialog.findViewById<TextView>(R.id.quiz_summ_titleDialog)
        val dialogGif = dialog.findViewById<GifImageView>(R.id.quiz_summ_gif)
        val dialogDescTW = dialog.findViewById<TextView>(R.id.quiz_summ_descr)
        val dialogNextTW = dialog.findViewById<RadioButton>(R.id.quiz_summ_next)
        val dialogCloseBTN = dialog.findViewById<ImageView>(R.id.quiz_summ_closeDialog)

        dialogTitleTW.text = CustomActivity.lastContext!!.getString(R.string.correct_answer)
        dialogTitleTW.setTextColor(CustomActivity.lastContext!!.getColor(R.color.darkgreen))
        dialogGif.setImageResource(R.drawable.tick_gif)
        dialogDescTW.text = CustomActivity.lastContext!!.getString(R.string.correct_answer_desc)
        dialogNextTW.setBackgroundResource(R.drawable.green_btn_icon)
        dialogCloseBTN.setOnClickListener{ dialog.dismiss() }

        dialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    open fun onAnswerWrong(answer: Any?){
        val dialog = Dialog(CustomActivity.lastContext!!)
        dialog.setContentView(R.layout.quiz_answer_summ)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogTitleTW = dialog.findViewById<TextView>(R.id.quiz_summ_titleDialog)
        val dialogGif = dialog.findViewById<GifImageView>(R.id.quiz_summ_gif)
        val dialogDescTW = dialog.findViewById<TextView>(R.id.quiz_summ_descr)
        val dialogNextTW = dialog.findViewById<RadioButton>(R.id.quiz_summ_next)
        val dialogCloseBTN = dialog.findViewById<ImageView>(R.id.quiz_summ_closeDialog)

        dialogTitleTW.text = CustomActivity.lastContext!!.getString(R.string.wrong_answer)
        dialogTitleTW.setTextColor(CustomActivity.lastContext!!.getColor(R.color.darkred))
        dialogGif.setImageResource(R.drawable.error_gif)
        dialogDescTW.text = CustomActivity.lastContext!!.getString(R.string.wrong_answer_desc)
        dialogNextTW.setBackgroundResource(R.drawable.red_button_icon)
        dialogCloseBTN.setOnClickListener{ dialog.dismiss() }

        dialog.show()
    }
}