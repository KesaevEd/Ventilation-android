package com.mvptest.presentation.ui.calculation.calculators

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
fun AirExchangeScreen(onBackPressed: () -> Unit){



    @Composable
    fun TestScreen() {
        BackHandler {
            onBackPressed()
        }
    }
}