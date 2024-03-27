package com.mvptest.presentation.ui.calculation.calculators.airductarea

data class AirDuctAreaViewState(
    val elements: List<AirDuctType> = listOf(),
    val totalArea: Double? = null,
)