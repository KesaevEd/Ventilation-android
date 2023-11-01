package com.mvptest.presentation.ui.calculation

import com.mvptest.domain.models.CalculationType
import com.mvptest.ventilation.R

data class CalculationResult(
    val type: CalculationType,
    val firstResult: String,
    val secondResult: String? = null
) {
    val firstTitleId: Pair<Int, Int> = when (type) {
        CalculationType.AIR_EXCHANGE -> {
            Pair(R.string.supply_air_volume, R.string.m3InH)
        }

        CalculationType.AERODYNAMIC -> {
            Pair(R.string.pressure_loss, R.string.pa)
        }

        CalculationType.DUCT_CROSS_SECTIONS -> {
            Pair(R.string.rectangle_area, R.string.mm)
        }

        CalculationType.DIFFUSERS -> {
            Pair(R.string.conditioner_power, R.string.count)
        }

        CalculationType.AIR_HEATER -> {
            Pair(R.string.air_heater_result, R.string.kvt)
        }

        CalculationType.CONDITIONER -> {
            Pair(R.string.conditioner_title, R.string.kvt)
        }
    }


    val secondTitleId: Pair<Int, Int> = when (type) {
        CalculationType.AIR_EXCHANGE -> {
            Pair(R.string.exhaust_air_volume, R.string.m3InH)
        }

        CalculationType.AERODYNAMIC -> {
            Pair(R.string.pressure_loss, R.string.pa)
        }

        CalculationType.DUCT_CROSS_SECTIONS -> {
            Pair(R.string.circle_diameter, R.string.mm)
        }

        CalculationType.DIFFUSERS -> {
            Pair(0, 0)
        }

        CalculationType.AIR_HEATER -> {
            Pair(0, 0)
        }

        CalculationType.CONDITIONER -> {
            Pair(0, 0)
        }
    }

}
