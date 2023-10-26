package com.mvptest.data.network.requests

data class NewRoomRequest(
    val id: String,
    val projectId: String,
    val userId: String,
    val title: String,
    val systemNumber: String,
    val roomVolume: String,
    val roomDestination: String,
    val airExchangePerformance: String,
    val pressureLoss: String,
    val airDuctArea: String,
    val startDate: String,
    val heaterType: String,
    val heaterPerformance: String,
    val isAirConditioner: Boolean,
    val airConditionerPerformance: String,
    val deadLines: String,
    val comment: String
)
