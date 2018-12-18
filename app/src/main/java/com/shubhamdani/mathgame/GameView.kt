package com.shubhamdani.mathgame

interface GameView {
    fun startTimer()
    fun restartTimer()
    fun resetNumber(generateRandomNumber: Int)

    fun displayScores(score: Int)
    fun resetInput()
    fun displayThumbsup()
    fun displayThumbsDown()
}
