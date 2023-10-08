package com.mvptest.presentation.ui.newroom

import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.RoomDetails
import java.util.UUID

data class NewRoomViewState(
    val id: String? = "",
    val title: String? = "",
    val systemNumber: String? = "",
    val roomVolume: Int? = null,
    val roomDestination: String? = "",
    val startDate: String? = "",
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

fun NewRoomViewState.toRoomDetails(): RoomDetails {
    return RoomDetails(
        id = UUID.randomUUID().toString(),
        title = title ?: "",
        systemNumber = systemNumber ?: "",
        roomVolume = roomVolume ?: 0,
        roomDestination = roomDestination ?: "",
        airExchangePerformance = airExchangePerformance ?: 0,
        pressureLoss = pressureLoss ?: 0,
        airDuctArea = airDuctArea ?: 0,
        heaterType = heaterType ?: HeaterType.NONE,
        heaterPerformance = heaterPerformance ?: 0,
        isAirConditioner = isAirConditioner ?: false,
        airConditionerPerformance = airConditionerPerformance ?: 0,
        deadLines = deadLines ?: "",
        comment = comment ?: ""
    )
}