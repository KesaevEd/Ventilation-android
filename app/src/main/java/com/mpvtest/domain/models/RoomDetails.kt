package com.mpvtest.domain.models

import java.util.Date

data class RoomDetails(
    val id: Int,
    val title: String,
    val systemNumber: String,
    val roomVolume: Int,
    val roomDestination: String,
    val airExchangePerformance: Int,
    val pressureLoss: Int,
    val airDuctArea: Int,
    val heaterType: HeaterType,
    val heaterPerformance: Int,
    val isAirConditioner: Boolean,
    val airConditionerPerformance: Int,
    val deadLines: String,
    val comment: String,
)

enum class HeaterType(){
    NONE, ELECTRICITY, WATER
}
