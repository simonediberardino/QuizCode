package com.quiz.code

import android.content.Intent
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

object Utility {
    fun replaceTabsWithSpaces(code: String) = code.replace("\t", "    ")

    @RequiresApi(api = Build.VERSION_CODES.N)
    fun enableTopBar(c: AppCompatActivity) {
        val resId = c.resources.getIdentifier("topbar", "drawable", c.packageName)
        c.supportActionBar!!.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        c.supportActionBar!!.setBackgroundDrawable(c.resources.getDrawable(resId))
        c.supportActionBar!!.setCustomView(R.layout.actionbar)
        val idS = "lefticon"
        val id = c.resources.getIdentifier(idS, "id", c.packageName)
        c.findViewById<View>(id).setOnClickListener { v: View? -> c.onBackPressed() }
    }

    fun navigateTo(c: AppCompatActivity, cl: Class<*>?) {
        val i = Intent(c, cl)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        c.startActivity(i)
    }

    // Ridimensiona i componenti in base alla dimensione dello schermo, NOTA: da utilizzare ogni qual volta si cambia la content view;
    fun ridimensionamento(activity: AppCompatActivity, v: ViewGroup) {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        val baseHeight = 1920.0
        val height = displayMetrics.heightPixels.toDouble()
        for (i in 0 until v.childCount) {
            val vAtI = v.getChildAt(i)
            val curHeight = vAtI.layoutParams.height
            val curWidth = vAtI.layoutParams.width
            val rapporto = height / baseHeight
            if (curHeight > ViewGroup.LayoutParams.MATCH_PARENT) vAtI.layoutParams.height =
                (curHeight * rapporto).toInt()
            if (curWidth > ViewGroup.LayoutParams.MATCH_PARENT) vAtI.layoutParams.width =
                (curWidth * rapporto).toInt()
            if (vAtI is TextView) {
                val curSize = vAtI.textSize.toInt()
                val newSize = (curSize * rapporto).toInt()
                vAtI.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSize.toFloat())
            }
            vAtI.requestLayout()
            if (vAtI is ViewGroup) {
                ridimensionamento(activity, vAtI)
            }
        }
    }
}