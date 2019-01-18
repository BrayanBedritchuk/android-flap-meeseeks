package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Meeseeks(val context: Context, val som: Som) : GameComponent {

    val WIDTH = 50f
    val RADIUS = 50
    var height = 50f
    val imgMeesseeks: Bitmap

    init {
        val bitmapMeesseeks = BitmapFactory.decodeResource(context.resources, R.drawable.passaro)
        imgMeesseeks = Bitmap.createScaledBitmap(bitmapMeesseeks,RADIUS * 2, RADIUS * 2, false )
    }

    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(imgMeesseeks, WIDTH - RADIUS, height - RADIUS, null)
    }

    fun goDown() {
        if (hasReachedBottomLimit()) {
            return
        }
        height += Screen.dpToPx(3).toFloat()
    }

    fun goUp() {
        if (hasReachedTopLimit()) {
            return
        }
        height -= Screen.dpToPx(50).toFloat()
        som.tocarSomDePulo()
    }

    private fun hasReachedTopLimit() = (height + RADIUS) < 0

    private fun hasReachedBottomLimit() = (height + RADIUS) > Screen.getHeight(context)

}