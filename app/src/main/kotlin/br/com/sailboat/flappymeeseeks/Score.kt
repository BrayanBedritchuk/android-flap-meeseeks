package br.com.sailboat.flappymeeseeks

import android.graphics.Canvas

class Score(val som: Som) : GameComponent {

    var score = 0

    override fun draw(canvas: Canvas) {
        canvas.drawText(score.toString(), 100f, 100f, ColorHelper.getScoreColor())
    }

    fun increaseScore() {
        score++
        som.tocarSomDePonto()
    }

}