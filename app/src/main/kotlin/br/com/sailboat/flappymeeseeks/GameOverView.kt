package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Canvas

class GameOverView(val context: Context) : GameComponent {

    override fun draw(canvas: Canvas) {
        val gameOver = "Game Over"
        canvas.drawText(gameOver, 0f, (Screen.getHeight(context) / 2).toFloat(), ColorHelper.getGameOverColor())
    }

}