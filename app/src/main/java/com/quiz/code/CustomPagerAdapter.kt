package com.quiz.code

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.PagerAdapter
import com.quiz.code.languages.java.Quizzes

class CustomPagerAdapter(private val mContext: Context, private val topics: Array<Class<Topic>>, private val nQuestions: Int) : PagerAdapter() {
    val pages: ArrayList<ViewGroup> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        if(pages.size > position)
            return pages[position]

        val inflater = LayoutInflater.from(mContext)
        val randomQuiz = GenerateRandomQuiz(topics.random())
        val layoutId = randomQuiz.layoutId
        val layout = inflater.inflate(layoutId, collection, false) as ViewGroup

        randomQuiz.layout = layout

        pages.add(layout)
        collection.addView(layout)

        return layout
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