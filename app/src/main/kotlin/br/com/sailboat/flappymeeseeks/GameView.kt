package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.View

class GameView(context: Context) : SurfaceView(context), Runnable, View.OnTouchListener {

    private val TAG = GameView::class.simpleName
    private var isRunning = true
    private val meeseeks = Meeseeks(context)
    private var pipes = Pipes(context)
    private val background: Bitmap

    init {
        val back = BitmapFactory.decodeResource(resources, R.drawable.background)
//        val back = BitmapHelper.getBitmapFromVectorDrawable(context, R.drawable.background2)
        background = Bitmap.createScaledBitmap(back, back.width, Screen.getHeight(context), false)
        setOnTouchListener(this)
    }

    override fun run() {
        while (isRunning) {

            if (isSurfaceNotValid()) {
                continue
            }

            val canvas = holder.lockCanvas()

            canvas.drawBitmap(background, 0f, 0f, null)
            meeseeks.draw(canvas)
            meeseeks.goDown()
            pipes.draw(canvas)
            pipes.moveToLeft()

            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun start() {
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        meeseeks.goUp()
        return true;
    }

    private fun isSurfaceNotValid() = !holder.surface.isValid

}