package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Canvas

class Pipe(val context: Context, var position: Float) : GameComponent {

    private val SIZE = 250f
    private val WIDTH = 100
    private val bottomPipeHeight: Float
    private val topPipeHeight: Float

    init {
        bottomPipeHeight = Screen.getHeight(context).toFloat() - SIZE - randomValue()
        topPipeHeight = SIZE + randomValue()
    }

    override fun draw(canvas: Canvas) {
        drawTopPipe(canvas)
        drawBottomPipe(canvas)
    }

    private fun drawBottomPipe(canvas: Canvas) {
        canvas.drawRect(
            position,
            bottomPipeHeight,
            position + WIDTH,
            Screen.getHeight(context).toFloat(),
            ColorHelper.getPipeColor()
        )
    }

    private fun drawTopPipe(canvas: Canvas) {
        canvas.drawRect(
            position,
            0f,
            position + WIDTH,
            topPipeHeight,
            ColorHelper.getPipeColor()
        )
    }

    fun moveToLeft() {
        position -= 5
    }

    fun isOutOfScreen() = (position + WIDTH) < 0

    private fun randomValue() = (Math.random() * 150).toInt()



}