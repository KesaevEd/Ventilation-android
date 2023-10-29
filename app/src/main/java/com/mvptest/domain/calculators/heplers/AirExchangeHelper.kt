package com.mvptest.domain.calculators.heplers

import android.util.Log
import com.mvptest.domain.calculators.CalculationResult
import com.mvptest.domain.models.CalculationType
import com.mvptest.presentation.ui.calculation.calculators.AirExchangeType

class AirExchangeHelper(
    private val type: AirExchangeType,
    private val roomVolume: String,
    private val airMultiplicity: Int,
    private val peopleCount: String,
    private val airFlowForOne: Int
) {

    fun calculate(): CalculationResult? {
        try {
            var result = 0
            if (type == AirExchangeType.MULTIPLICITY) {
                result = roomVolume.toInt() * airMultiplicity
            } else {
                result = peopleCount.toInt() * airFlowForOne
            }
            return CalculationResult(
                type = CalculationType.AIR_EXCHANGE,
                result.toString(),
                (result * 0.9).toInt().toString()
            )
        } catch (e: Exception) {
            Log.e("error", "AirExchangeHelper Error = $e")
            return null
        }
    }
}