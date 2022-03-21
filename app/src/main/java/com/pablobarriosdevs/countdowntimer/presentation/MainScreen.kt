package com.pablobarriosdevs.countdowntimer.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: TimerViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = viewModel.timerState.value.formatTime(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (!viewModel.isRunning.value) {
                        viewModel.timer.startTimer()
                    }else{
                        viewModel.timer.pauseTimer()
                    }
                }

            ) {
                Text(
                    text = if (viewModel.isRunning.value) "PAUSAR" else "INICIAR"
                )
            }

            if (!viewModel.finished.value) {

                Spacer(modifier = Modifier.width(50.dp))

                Button(
                    onClick = { viewModel.timer.resetTimer() }

                ) {
                    Text(
                        text = "RESET"
                    )

                }
            }
        }
    }


}