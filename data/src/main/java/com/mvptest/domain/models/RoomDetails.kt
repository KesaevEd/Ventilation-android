package com.mvptest.domain.models

import androidx.compose.ui.res.stringResource
import com.mvptest.data.R

data class RoomDetails(
    val id: String,
    val title: String,
    val systemNumber: String,
    val roomVolume: Int,
    val roomDestination: String,
    val airExchangePerformance: Int,
    val pressureLoss: Int,
    val airDuctArea: Int,
    val startDate: String,
    val heaterType: HeaterType,
    val heaterPerformance: Int,
    val isAirConditioner: Boolean,
    val airConditionerPerformance: Int,
    val deadLines: String,
    val comment: String,
)

enum class HeaterType(val string: String){
    NONE("Нет"), ELECTRICITY("Электро"), WATER("Водяной")
}
