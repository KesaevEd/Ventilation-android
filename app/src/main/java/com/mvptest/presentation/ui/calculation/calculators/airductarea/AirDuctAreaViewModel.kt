package com.mvptest.presentation.ui.calculation.calculators.airductarea

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AirDuctAreaViewModel : ViewModel() {
    var state by mutableStateOf(AirDuctAreaViewState())
    var elementNumber = 1
    var totalArea by mutableDoubleStateOf(0.0)
}
