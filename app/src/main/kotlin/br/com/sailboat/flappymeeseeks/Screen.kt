package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object Screen {

    fun getHeight(context: Context): Int {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = manager.defaultDisplay
        val displayMetrics = DisplayMetrics()

        display.getMetrics(displayMetrics)

        return displayMetrics.heightPixels
    }

}