package com.mvptest.domain.calculators

import com.mvptest.domain.models.CalculationType
import com.mvptest.ventilation.R

data class CalculationResult(
    val type: CalculationType,
    val firstResult: String,
    val secondResult: String? = null
) {
    val firstTitleId: Pair<Int, Int> = when (type) {
        CalculationType.AIR_EXCHANGE -> {
            Pair(0, 0)
        }

        CalculationType.AERODYNAMIC -> {
            Pair(R.string.pressure_loss, R.string.pa)
        }

        CalculationType.DUCT_CROSS_SECTIONS -> {
            Pair(R.string.rectangle_area, R.string.mm)
        }

        CalculationType.DIFFUSERS -> {
            Pair(R.string.conditioner_power, R.string.kvt)
        }

        CalculationType.AIR_HEATER -> {
            Pair(0, 0)
        }

        CalculationType.CONDITIONER -> {
            Pair(R.string.conditioner_title, 0)
        }
    }


    val secondTitleId: Pair<Int, Int> = when (type) {
        CalculationType.AIR_EXCHANGE -> {
            Pair(0, 0)
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
