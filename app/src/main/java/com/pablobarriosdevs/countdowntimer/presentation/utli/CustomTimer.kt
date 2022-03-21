package com.pablobarriosdevs.countdowntimer.presentation.utli

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState

class CustomTimer(
    var initTime: MutableState<Long>,
    val interval: Long = 1000L,
    var finished: MutableState<Boolean> ,
    var isRunning: MutableState<Boolean> ,
) {
    private lateinit var timer: CountDownTimer

    var timerInitialValue = initTime.value

    fun startTimer() {

        timer = object : CountDownTimer(initTime.value, interval) {

            override fun onTick(p0: Long) {
                initTime.value = p0

            }

            override fun onFinish() {
                resetTimer()
            }
        }.start()
        isRunning.value = true
        finished.value = false
    }

    fun pauseTimer() {
        timer.cancel()
        isRunning.value = false
    }

    fun resetTimer() {
        timer.cancel()
        isRunning.value = false
        finished.value = true
        initTime.value = timerInitialValue
    }


}