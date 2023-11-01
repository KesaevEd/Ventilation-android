package com.mvptest.presentation.ui.room.newroom

import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.RoomDetails
import com.mvptest.domain.models.VentSystemDestination

data class NewRoomViewState(
    val id: String? = "",
    val title: String? = "",
    val systemNumber: String? = "",
    val ventSystemDestination: VentSystemDestination? = VentSystemDestination.FORCED,
    val startDate: String? = "",
    val airExchangePerformance: String? = null,
    val pressureLoss: String? = null,
    val airDuctArea: String? = null,
    val heaterType: HeaterType? = null,
    val heaterPerformance: String? = null,
    val isAirConditioner: Boolean? = false,
    val airConditionerPerformance: String? = null,
    val deadLines: String? = "",
    val comment: String? = "",
)

fun NewRoomViewState.toRoomDetails(roomId: String): RoomDetails {
    return RoomDetails(
        id = roomId,
        title = title ?: "",
        systemNumber = systemNumber ?: "",
        ventSystemDestination = ventSystemDestination ?: VentSystemDestination.FORCED,
        airExchangePerformance = airExchangePerformance ?: "",
        pressureLoss = pressureLoss ?: "",
        airDuctCrossSize = airDuctArea ?: "",
        heaterType = heaterType ?: HeaterType.NONE,
        heaterPerformance = heaterPerformance ?: "",
        isAirConditioner = isAirConditioner ?: false,
        airConditionerPerformance = airConditionerPerformance ?: "",
        startDate = startDate ?: "",
        deadLines = deadLines ?: "",
        comment = comment ?: ""
    )
}

fun RoomDetails.toRoomViewState(id: String): NewRoomViewState {
    return NewRoomViewState(
        id = id,
        title = title ?: "",
        systemNumber = systemNumber ?: "",
        ventSystemDestination = ventSystemDestination,
        airExchangePerformance = airExchangePerformance ?: "",
        pressureLoss = pressureLoss ?: "",
        airDuctArea = airDuctCrossSize ?: "",
        heaterType = heaterType ?: HeaterType.NONE,
        heaterPerformance = heaterPerformance ?: "",
        isAirConditioner = isAirConditioner ?: false,
        airConditionerPerformance = airConditionerPerformance ?: "",
        startDate = startDate ?: "",
        deadLines = deadLines ?: "",
        comment = comment ?: ""
    )
}