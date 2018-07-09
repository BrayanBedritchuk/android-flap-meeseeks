package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Canvas

class Pipes(val context: Context) : GameComponent {

    private val AMOUNT_OF_PIPES = 5
    private val DISTANCE_BETWEEN_PIPES = 200
    private val pipes = mutableListOf<Pipe>()

    init {
        var position = 400f

        for (i in 1..AMOUNT_OF_PIPES) {
            position += DISTANCE_BETWEEN_PIPES
            pipes.add(Pipe(context, position))
        }
    }

    override fun draw(canvas: Canvas) {
        pipes.forEach { it.draw(canvas) }
    }

    fun moveToLeft() {
        val iterator = pipes.listIterator()

        while (iterator.hasNext()) {
            val pipe = iterator.next()
            pipe.moveToLeft()

            if (pipe.isOutOfScreen()) {
                iterator.remove()
                val pipe = Pipe(context, getMaxPosition() + DISTANCE_BETWEEN_PIPES)
                iterator.add(pipe)
            }
        }
    }

    private fun getMaxPosition(): Float {
        var max = 0f
        pipes.forEach { max = Math.max(it.position, max) }

        return max
    }


}