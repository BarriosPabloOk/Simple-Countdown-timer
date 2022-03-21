package com.pablobarriosdevs.countdowntimer.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pablobarriosdevs.countdowntimer.presentation.utli.CustomTimer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import java.util.concurrent.TimeUnit

class TimerViewModel : ViewModel() {

    //Instance and Compose States to handle the composables

    private val _timerState = mutableStateOf(30000L)
    val timerState: State<Long> = _timerState

    private val _finished = mutableStateOf<Boolean>(true)
    val finished: State<Boolean> = _finished

    private val _isRunning = mutableStateOf(false)
    val isRunning: State<Boolean> = _isRunning

    val timer = CustomTimer(_timerState, 1000L, _finished, _isRunning)


}