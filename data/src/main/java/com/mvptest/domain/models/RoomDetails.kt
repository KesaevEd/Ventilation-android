package com.mvptest.domain.models

data class RoomDetails(
    val id: String,
    val title: String,
    val systemNumber: String,
    val ventSystemDestination: VentSystemDestination,
    val airExchangePerformance: String,
    val pressureLoss: String,
    val airDuctCrossSize: String,
    val startDate: String,
    val heaterType: HeaterType,
    val heaterPerformance: String,
    val isAirConditioner: Boolean,
    val airConditionerPerformance: String,
    val deadLines: String,
    val comment: String,
)

enum class HeaterType(val string: String) {
    NONE("Нет"), ELECTRICITY("Электро"), WATER("Водяной")
}

enum class VentSystemDestination(val string: String) {
    FORCED("Приточная"), EXHAUST("Вытяжная"), FORCED_EXHAUST("Приточно-вытяжная")
}
