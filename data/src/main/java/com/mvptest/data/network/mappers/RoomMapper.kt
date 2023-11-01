package com.mvptest.data.network.mappers

import android.util.Log
import com.mvptest.data.network.requests.NewRoomRequest
import com.mvptest.data.network.responses.RoomResponse
import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.RoomDetails
import com.mvptest.domain.models.VentSystemDestination

fun RoomResponse.toRoomDetails(): RoomDetails{
    Log.d("saveroom","toRoomDetails")
    return RoomDetails(
        id = id,
        title = title,
        systemNumber = systemNumber ?: "",
        ventSystemDestination = ventSystemDestination?.let { VentSystemDestination.valueOf(it) } ?: VentSystemDestination.FORCED,
        airExchangePerformance = airExchangePerformance ?: "",
        pressureLoss = pressureLoss?: "",
        airDuctCrossSize = airDuctArea?: "",
        heaterType = heaterType?.let { HeaterType.valueOf(it) } ?: HeaterType.NONE,
        heaterPerformance = heaterPerformance?: "",
        isAirConditioner = isAirConditioner?: false,
        airConditionerPerformance = airConditionerPerformance?: "",
        startDate = startDate?: "",
        deadLines = deadLines?: "",
        comment = comment?: ""
    )
}

fun RoomDetails.toRoomRequest(userId: String, projectId: String): NewRoomRequest{
    return NewRoomRequest(
        id = id,
        userId = userId,
        projectId = projectId,
        title = title,
        systemNumber = systemNumber,
        ventSystemDestination = ventSystemDestination.name,
        airExchangePerformance = airExchangePerformance,
        pressureLoss = pressureLoss,
        airDuctArea = airDuctCrossSize,
        heaterType = heaterType.name,
        heaterPerformance = heaterPerformance,
        isAirConditioner = isAirConditioner,
        airConditionerPerformance = airConditionerPerformance,
        startDate = startDate,
        deadLines = deadLines,
        comment = comment
    )
}