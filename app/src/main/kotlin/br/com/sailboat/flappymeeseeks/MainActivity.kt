package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var gameView: GameView

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameView = GameView(this)
        container.addView(gameView)
    }

    override fun onResume() {
        super.onResume()
        gameView.start()
        Thread(gameView).start()
    }

    override fun onPause() {
        super.onPause()
        gameView.stop()
    }

}