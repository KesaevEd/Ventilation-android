package com.mvptest.presentation.ui.calculation.calculators.airheater

import android.util.Log
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.domain.models.CalculationType

class AirHeaterHelper(
    private val airFlow: String,
    private val tempAfterHeater: String,
    private val tempOutside: String
) {

    fun calculate(): CalculationResult? {
        try {
            val p = 1.205 * ((273.15 + tempAfterHeater.toInt())/(273.15 + tempOutside.toInt()))
            var result = airFlow.toFloat() * p * (tempAfterHeater.toFloat() - tempOutside.toFloat())
            result /= 3600
            return CalculationResult(
                type = CalculationType.AIR_HEATER,
                result.toInt().toString()
            )
        } catch (e: Exception) {
            Log.e("error", "AirExchangeHelper Error = $e")
            return null
        }
    }
}