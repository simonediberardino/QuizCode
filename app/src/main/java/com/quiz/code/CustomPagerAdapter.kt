package com.quiz.code

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.quiz.code.languages.java.Quizzes

class CustomPagerAdapter(private val mContext: Context, private val topics: Array<Class<Topic>>, private val nQuestions: Int) : PagerAdapter() {
    val pages: ArrayList<ViewGroup> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val randomQuiz = GenerateRandomQuiz(topics.random())
        val layoutId = randomQuiz.layoutId

        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(layoutId, collection, false) as ViewGroup

        selectDot(layout, position)

        randomQuiz.layout = layout

        if(pages.size > position)
            return pages[position]

        pages.add(layout)
        collection.addView(layout)

        return layout
    }

    fun selectDot(layout: ViewGroup, position: Int){
        val boxSize = layout.findViewById<ConstraintLayout>(R.id.quiz_mo_constraintLayout).layoutParams.width
        val dotMargin = 4
        val dotSize = boxSize / (nQuestions) - dotMargin
        val dotsLayout = layout.findViewById<LinearLayout>(R.id.quiz_mo_dots)

        dotsLayout.removeAllViews()

        for(index in 0 until nQuestions) {
            val viewToAdd = ImageView(mContext)
            val isSelected = index == position

            val drawableId = if(isSelected) R.drawable.selected_dot else R.drawable.default_dot
            viewToAdd.alpha = if(isSelected) 1F else 0.5F
            viewToAdd.minimumWidth = dotSize
            viewToAdd.minimumHeight = dotSize

            viewToAdd.setImageResource(drawableId)
            dotsLayout.addView(viewToAdd)
        }

        Utility.ridimensionamento(mContext as AppCompatActivity, dotsLayout)
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any){}
    override fun getCount() = nQuestions
    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    data class GenerateRandomQuiz(val topic: Class<*>){
        val quiz: QuizQuestion

        var layout: ViewGroup
            get() { return layout }
            set(value){
                quiz.showQuestion(value)
            }

        val layoutId: Int get(){
            return when(quiz.type){
                QuizChoices::class.java -> R.layout.quiz_multiple_options
                else -> 0
            }
        }

        init {
            val quizzes = Quizzes.quizzes.filter { it.topic == topic }
            quiz = quizzes.random()
        }
    }
}