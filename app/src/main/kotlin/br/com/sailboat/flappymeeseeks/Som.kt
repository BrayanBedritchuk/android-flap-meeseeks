package br.com.sailboat.flappymeeseeks

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool

class Som(context: Context) {

    private val soundPool: SoundPool
    private val idSomPulo: Int
    private val idSomPonto: Int
    private val idSomColisao: Int

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(3)
            .setAudioAttributes(audioAttributes).build()

        idSomPulo = soundPool.load(context, R.raw.pulo, 1)
        idSomPonto = soundPool.load(context, R.raw.pontos, 1)
        idSomColisao = soundPool.load(context, R.raw.colisao, 1)
    }

    fun tocarSom(idSom: Int) {
        soundPool.play(idSom, 1f, 1f, 1, 0, 1f);
    }

    fun tocarSomDePulo() {
        tocarSom(idSomPulo)
    }

    fun tocarSomDePonto() {
        tocarSom(idSomPonto)
    }

    fun tocarSomDeColisao() {
        tocarSom(idSomColisao)
    }

}