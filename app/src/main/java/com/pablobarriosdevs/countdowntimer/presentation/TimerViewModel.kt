package com.pablobarriosdevs.countdowntimer.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import java.util.concurrent.TimeUnit

class TimerViewModel : ViewModel() {

    //Instance and Compose States to handle the composables
    private lateinit var timer: CountDownTimer
    val timerCount = 30000L

    private val _timerState = mutableStateOf(timerCount)
    val timerState: State<Long> = _timerState

    private val _finished = mutableStateOf<Boolean>(true)
    val finished: State<Boolean> = _finished

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning


    fun startTimer() {

        timer = object : CountDownTimer(_timerState.value, 1000) {

            override fun onTick(p0: Long) {
                _timerState.value = p0

            }

            override fun onFinish() {
                resetTimer()
            }
        }.start()
        _isRunning.value = true
        _finished.value = false
    }

    fun pauseTimer() {
        timer.cancel()
        _isRunning.value = false
    }

    fun resetTimer() {
        timer.cancel()
        _isRunning.value = false
        _finished.value = true
        _timerState.value = timerCount
    }


}