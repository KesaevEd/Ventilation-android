package com.mvptest.domain.models

import androidx.compose.ui.res.stringResource
import com.mvptest.data.R

data class RoomDetails(
    val id: String,
    val title: String,
    val systemNumber: String,
    val roomVolume: String,
    val roomDestination: String,
    val airExchangePerformance: String,
    val pressureLoss: String,
    val airDuctArea: String,
    val startDate: String,
    val heaterType: HeaterType,
    val heaterPerformance: String,
    val isAirConditioner: Boolean,
    val airConditionerPerformance: String,
    val deadLines: String,
    val comment: String,
)

enum class HeaterType(val string: String){
    NONE("Нет"), ELECTRICITY("Электро"), WATER("Водяной")
}
