package com.mvptest.data.network.requests

import com.mvptest.domain.models.VentSystemDestination

data class NewRoomRequest(
    val id: String,
    val projectId: String,
    val userId: String,
    val title: String,
    val systemNumber: String,
    val ventSystemDestination: String,
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
