package com.quiz.code

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.children
import androidx.viewpager.widget.PagerAdapter

class CustomPagerAdapter(private val mContext: Context, private val nQuestions: Int) : PagerAdapter() {
    private var collection: ViewGroup? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.quiz_multiple_options, collection, false) as ViewGroup
        this.collection = collection

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return nQuestions
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    fun getViews(): Sequence<View>? {
        return collection?.children
    }
}