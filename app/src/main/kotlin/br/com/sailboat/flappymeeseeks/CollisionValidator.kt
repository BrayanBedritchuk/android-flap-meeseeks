package br.com.sailboat.flappymeeseeks

class CollisionValidator(private val meeseeks: Meeseeks, private val pipes: Pipes) {

    fun hasCollisionOccurred() = pipes.hasCollisionWithMeeseeks(meeseeks)

}