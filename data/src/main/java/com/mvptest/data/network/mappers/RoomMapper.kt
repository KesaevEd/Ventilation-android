package com.mvptest.data.network.mappers

import com.mvptest.data.network.requests.NewRoomRequest
import com.mvptest.data.network.responses.ProjectResponse
import com.mvptest.data.network.responses.RoomResponse
import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.RoomDetails

fun RoomResponse.toRoomDetails(): RoomDetails{
    return RoomDetails(
        id = id,
        title = title,
        systemNumber = systemNumber,
        roomVolume = roomVolume,
        roomDestination = roomDestination,
        airExchangePerformance = airExchangePerformance,
        pressureLoss = pressureLoss,
        airDuctArea = airDuctArea,
        heaterType = HeaterType.valueOf(heaterType),
        heaterPerformance = heaterPerformance,
        isAirConditioner = isAirConditioner,
        airConditionerPerformance = airConditionerPerformance,
        startDate = startDate,
        deadLines = deadLines,
        comment = comment
    )
}

fun RoomDetails.toRoomRequest(userId: String, projectId: String): NewRoomRequest{
    return NewRoomRequest(
        id = id,
        userId = userId,
        projectId = projectId,
        title = title,
        systemNumber = systemNumber,
        roomVolume = roomVolume,
        roomDestination = roomDestination,
        airExchangePerformance = airExchangePerformance,
        pressureLoss = pressureLoss,
        airDuctArea = airDuctArea,
        heaterType = heaterType.name,
        heaterPerformance = heaterPerformance,
        isAirConditioner = isAirConditioner,
        airConditionerPerformance = airConditionerPerformance,
        startDate = startDate,
        deadLines = deadLines,
        comment = comment
    )
}