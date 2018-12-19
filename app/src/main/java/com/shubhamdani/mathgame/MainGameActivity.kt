package com.shubhamdani.mathgame

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main_game.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper


class MainGameActivity : AppCompatActivity(), GameView, CountdownListener, TextWatcher {

    lateinit var mPresenter: MainGamePresenterImpl
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)
        mPresenter = MainGamePresenterImpl(this)
        timer = Timer(this@MainGameActivity)
        mPresenter.startGame()
        edtEnteredAnswer.addTextChangedListener(this)
    }

    override fun startTimer() {
        timer.start()
    }

    override fun restartTimer() {
        timer.cancel()
        timer.start()
    }

    override fun onFinish() {
        mPresenter.resetGame()
    }

    override fun onTick(millisUntilFinished: Long) {
        txtTimer.text = millisUntilFinished.div(1000).toString()
    }

    override fun resetNumber(generateRandomNumber: Int) {
        txtRandomNumber.text = generateRandomNumber.toString()
    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mPresenter.checkValues(s?.toString())
    }

    override fun displayScores(score: Int) {
        txtScore.text = score.toString()
    }

    override fun resetInput() {
        edtEnteredAnswer.setText("")
    }

    override fun displayThumbsup() {
        Timer(object : CountdownListener {
            override fun onFinish() {
                imgThumbsUp.visibility = View.GONE
                mPresenter.nextNumber()
            }

            override fun onTick(millisUntilFinished: Long) {
                imgThumbsUp.visibility = View.VISIBLE
                timer.cancel()
            }
        }, 2000).start()
    }

    override fun displayThumbsDown() {
        Timer(object : CountdownListener {
            override fun onFinish() {
                imgThumbsDown.visibility = View.GONE
                mPresenter.resetGame()
            }

            override fun onTick(millisUntilFinished: Long) {
                imgThumbsDown.visibility = View.VISIBLE
                timer.cancel()
            }
        }, 2000).start()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}

class Timer(val listener: CountdownListener, val timer: Long = 15000, val interval: Long = 1000) :
    CountDownTimer(timer, interval) {

    var isOn: Boolean = false

    override fun onFinish() {
        isOn = false
        listener.onFinish()
    }

    override fun onTick(millisUntilFinished: Long) {
        isOn = true
        listener.onTick(millisUntilFinished)
    }
}

interface CountdownListener {
    fun onFinish()
    fun onTick(millisUntilFinished: Long)
}
