package com.mvptest.domain.models

data class CalculateItem(
    val type: CalculationType,
    val titleId1: Int,
    val titleId: Int,
    val iconId: Int
)

enum class CalculationType{
    AIR_EXCHANGE, DUCT_CROSS_SECTIONS, AIR_HEATER, DIFFUSERS, AERODYNAMIC, CONDITIONER
}