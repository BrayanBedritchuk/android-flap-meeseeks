package br.com.sailboat.flappymeeseeks

import android.graphics.Color
import android.graphics.Paint

object ColorHelper {

    fun getMeeseeksColor(): Paint {
        val paint = Paint()
        paint.color = Color.GREEN
        return paint
    }

    fun getPipeColor(): Paint {
        val paint = Paint()
        paint.color = Color.RED
        return paint
    }

}