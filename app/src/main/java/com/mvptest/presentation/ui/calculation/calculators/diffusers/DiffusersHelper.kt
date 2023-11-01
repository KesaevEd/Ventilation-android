package com.mvptest.presentation.ui.calculation.calculators.diffusers

import android.util.Log
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.domain.models.CalculationType
import kotlin.math.ceil

class DiffusersHelper(
    private val airDuctArea: String,
    private val airDuctDiameter: String,
    private val airFlow: String,
    private val airSpeed: Int
) {

    fun calculate(): CalculationResult?{
        try {
            val airFlowLocal = airFlow.toFloat()
            if (airDuctArea != "") {
                val split = airDuctArea.split("*")
                val area = (split[0].toFloat() * split[1].toFloat()) / 1000000
                val result = ceil(airFlowLocal / (3600 * airSpeed.toFloat() * area))
                return CalculationResult(CalculationType.DIFFUSERS, result.toInt().toString())
            } else if (airDuctDiameter != "") {
                val diameter = airDuctDiameter.toFloat() / 1000
                val result =
                    ceil(airFlowLocal / (2820 * airSpeed.toFloat() * diameter * diameter))
                return CalculationResult(CalculationType.DIFFUSERS, result.toInt().toString())
            }
        } catch (e: Exception){
            Log.e("error","Diffusers Error = $e")
            return null
        }
        return null
    }
}