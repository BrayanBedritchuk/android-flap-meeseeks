package br.com.sailboat.flappymeeseeks

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface

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

    fun getScoreColor(): Paint {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.textSize = 80f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.setShadowLayer(3f, 5f,5f, 0xFF000000.toInt())
        return paint
    }

    fun getGameOverColor(): Paint {
        val vermelho = Paint()
        vermelho.color = 0xFFFF0000.toInt()
        vermelho.textSize = 50f
        vermelho.typeface = Typeface.DEFAULT_BOLD
        vermelho.setShadowLayer(2f, 3f, 3f, 0xFF000000.toInt())
        return vermelho
    }

}