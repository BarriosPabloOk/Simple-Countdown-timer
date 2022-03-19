package com.pablobarriosdevs.countdowntimer.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class TimerViewModel: ViewModel() {

    //Instance and Compose States to handle the composables
    val timerCount = 30000L
    private val _timerState = mutableStateOf(timerCount/1000)
    val timerState : State<Long> = _timerState


    private val _finished = mutableStateOf<Boolean>(false)
    val finished : State<Boolean> = _finished




    private val timer = object :CountDownTimer(timerCount , 1000){

        override fun onTick(p0: Long) {
            _timerState.value = p0/1000

        }

        override fun onFinish() {
            _finished.value = true
        }
    }

    fun start(){
        timer.start()
    }

    fun stopTimer(){
        timer.cancel()
    }


}