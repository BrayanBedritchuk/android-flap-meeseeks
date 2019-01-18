package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Pipe(val context: Context, var position: Float) : GameComponent {

    private val SIZE = 250
    private val WIDTH = 100
    private val bottomPipeHeight: Int
    private val topPipeHeight: Int
    val imgBottomPipe: Bitmap
    val imgTopPipe: Bitmap

    init {
        bottomPipeHeight = Screen.getHeight(context) - SIZE - randomValue()
        topPipeHeight = SIZE + randomValue()
        val bp = BitmapFactory.decodeResource(context.resources, R.drawable.cano)
        imgBottomPipe = Bitmap.createScaledBitmap(bp, WIDTH, bottomPipeHeight, false )

        imgTopPipe = Bitmap.createScaledBitmap(bp, WIDTH, topPipeHeight, false )
    }

    override fun draw(canvas: Canvas) {
        drawTopPipe(canvas)
        drawBottomPipe(canvas)
    }

    private fun drawBottomPipe(canvas: Canvas) {
        canvas.drawBitmap(imgBottomPipe, position, bottomPipeHeight.toFloat(), null)
    }

    private fun drawTopPipe(canvas: Canvas) {
        canvas.drawBitmap(imgTopPipe, position, 0f, null)
    }

    fun moveToLeft() {
        position -= 5
    }

    fun hasHorizontalCollision(meeseeks: Meeseeks): Boolean {
        return position < (meeseeks.WIDTH + meeseeks.RADIUS)
    }

    fun hasVerticalCollision(meeseeks: Meeseeks): Boolean {
        return ((meeseeks.height - meeseeks.RADIUS) < topPipeHeight) ||
                ((meeseeks.height + meeseeks.RADIUS) > bottomPipeHeight)
    }

    fun isOutOfScreen() = (position + WIDTH) < 0

    private fun randomValue() = (Math.random() * 150).toInt()

}