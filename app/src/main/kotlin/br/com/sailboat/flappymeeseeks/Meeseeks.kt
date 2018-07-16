package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Canvas

class Meeseeks(val context: Context) : GameComponent {

    val WIDTH = 50f
    val RADIUS = 50f
    val COLOR = ColorHelper.getMeeseeksColor()
    var height = 50f

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(WIDTH, height, RADIUS, COLOR)
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
    }

    private fun hasReachedTopLimit() = (height + RADIUS) < 0

    private fun hasReachedBottomLimit() = (height + RADIUS) > Screen.getHeight(context)

}