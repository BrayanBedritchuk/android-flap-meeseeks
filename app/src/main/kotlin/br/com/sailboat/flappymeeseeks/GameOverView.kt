package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

class GameOverView(val context: Context) : GameComponent {


    val gameOverColor = ColorHelper.getGameOverColor()

    override fun draw(canvas: Canvas) {
        val gameOver = "Game Over"
        val center = centerText(gameOver)
        canvas.drawText(gameOver, center.toFloat(), (Screen.getHeight(context) / 2).toFloat(), gameOverColor)
    }

    private fun centerText(gameOver: String): Int {
        val textLimit = Rect()
        gameOverColor.getTextBounds(gameOver, 0, gameOver.length, textLimit)
        val centerHorizontal = Screen.getWidth(context) / 2 - (textLimit.right - textLimit.left) / 2

        return centerHorizontal
    }

}