package com.mvptest.data.database.mappers

import com.mvptest.data.database.entities.ProjectDbEntity
import com.mvptest.data.database.entities.RoomDbEntity
import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.Project
import com.mvptest.domain.models.RoomDetails

fun Project.toDbEntity(): ProjectDbEntity =
    ProjectDbEntity(
        id = id,
        title = title,
        address = address,
        startDate = startDate ?: "",
        contact = contact ?: "",
        contactPhone = contactPhone ?: ""
    )

fun ProjectDbEntity.toProject(): Project =
    Project(
        id = id,
        title = title,
        address = address,
        startDate = startDate,
        contact = contact,
        contactPhone = contactPhone
    )

fun RoomDetails.toDbEntity(projectId: String): RoomDbEntity =
    RoomDbEntity(
        id = id,
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

fun RoomDbEntity.toRoomDetails(): RoomDetails =
    RoomDetails(
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