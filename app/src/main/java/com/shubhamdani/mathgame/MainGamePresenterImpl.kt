package com.shubhamdani.mathgame

import java.util.*

class MainGamePresenterImpl(val views: GameView) : BaseGamePresenter<GameView>(), MainGamePresenter<GameView> {

    var generateRandomNumber: Int = -1
    var scores: Int = 0

    init {
        attach(views)
    }

    override fun startGame() {
        getView()?.apply {
            startTimer()
            resetNumber(generateRandomNumber())
        }
    }

    override fun resetGame() {
        getView()?.apply {
            restartTimer()
            scores = 0
            displayScores(scores)
            resetInput()
            resetNumber(generateRandomNumber())
        }
    }

    fun nextNumber() {
        getView()?.apply {
            restartTimer()
            resetNumber(generateRandomNumber())
            resetInput()
        }
    }

    override fun checkValues(value: String?) {
        if (value?.length == 4) {
            if (generateRandomNumber.plus(1111) == value?.toInt()) {
                scores = scores.plus(1)
                getView()?.displayThumbsup()
                getView()?.displayScores(scores)
            } else {
                getView()?.displayThumbsDown()
            }
        }
    }

    private fun generateRandomNumber(): Int {
        val random = Random()
        generateRandomNumber = random.nextInt(8999) + 1
        return generateRandomNumber
    }

}
