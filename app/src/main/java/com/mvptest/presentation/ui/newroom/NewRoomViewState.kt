package com.mvptest.presentation.ui.newroom

import com.mvptest.domain.models.HeaterType

data class NewRoomViewState (
    val id: Int? = 0,
    val title: String? = "",
    val systemNumber: String? = "",
    val roomVolume: Int? = null,
    val roomDestination: String? = "",
    val airExchangePerformance: Int? = null,
    val pressureLoss: Int? = null,
    val airDuctArea: Int? = null,
    val heaterType: com.mvptest.domain.models.HeaterType? = null,
    val heaterPerformance: Int? = null,
    val isAirConditioner: Boolean? = false,
    val airConditionerPerformance: Int? = null,
    val deadLines: String? = "",
    val comment: String? = "",
)