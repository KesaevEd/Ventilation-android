package com.mpvtest.presentation.ui.newroom

import com.mpvtest.domain.models.HeaterType
import com.mpvtest.domain.models.RoomDetails
import java.util.Date

data class NewRoomViewState (
    val id: Int? = 0,
    val title: String? = "",
    val systemNumber: String? = "",
    val roomVolume: Int? = null,
    val roomDestination: String? = "",
    val airExchangePerformance: Int? = null,
    val pressureLoss: Int? = null,
    val airDuctArea: Int? = null,
    val heaterType: HeaterType? = null,
    val heaterPerformance: Int? = null,
    val isAirConditioner: Boolean? = false,
    val airConditionerPerformance: Int? = null,
    val deadLines: String? = "",
    val comment: String? = "",
)