package com.mvptest.presentation.ui.calculation.calculators.ductcross

import android.util.Log
import com.mvptest.presentation.ui.calculation.ventilationconstans.airDuctSizes
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.domain.models.CalculationType

class DuctAreaHelper(
    private val airFlow: String,
    private val airSpeed: Int
) {

    fun calculate(): CalculationResult? {
        var rectCut = ""
        var circleCut = ""

        try {
            if (airSpeed != 0) {
                val calculatingCutArea = airFlow.toFloat() / (3600 * airSpeed.toFloat())

                for (size in airDuctSizes) {
                    val currentCutArea = getCutArea(size)

                    if (airDuctSizes.indexOf(size) == 0 && calculatingCutArea < currentCutArea) {

                        rectCut = airDuctSizes[0]
                        circleCut = fromRectToCircleArea(rectCut)

                    } else if (size == airDuctSizes.last() && (calculatingCutArea > currentCutArea)) {

                        rectCut = airDuctSizes.last()
                        circleCut = fromRectToCircleArea(rectCut)

                    } else if (currentCutArea < calculatingCutArea && calculatingCutArea < getNextSize(
                            size
                        )
                    ) {
                        if ((calculatingCutArea - currentCutArea) < (getNextSize(size) - calculatingCutArea)
                        ) {
                            rectCut = size
                            circleCut = fromRectToCircleArea(rectCut)
                        } else {
                            rectCut = airDuctSizes[airDuctSizes.indexOf(size) + 1]
                            circleCut = fromRectToCircleArea(rectCut)

                        }
                    }
                }

                return CalculationResult(CalculationType.DUCT_CROSS_SECTIONS, rectCut, circleCut)
            } else {
                return null
            }

        } catch (e: Exception) {
            Log.e("error", "Diffusers Error = $e")
            return null
        }
    }

    private fun fromRectToCircleArea(rectCut: String): String {
        return ((2 * rectCut.split("*")[0].toInt() * rectCut.split("*")[1].toInt()) / (rectCut.split(
            "*"
        )[0].toInt() + rectCut.split("*")[1].toInt())).toString()
    }

    private fun getCutArea(rectCut: String): Float {
        return (rectCut.split("*")[0].toFloat() / 1000) * (rectCut.split("*")[1].toFloat() / 1000)
    }

    private fun getNextSize(currentSize: String): Float {
        return ((airDuctSizes[airDuctSizes.indexOf(
            currentSize
        ) + 1].split(
            "*"
        )[0].toFloat() / 1000) * (airDuctSizes[airDuctSizes.indexOf(currentSize) + 1].split(
            "*"
        )[1].toFloat() / 1000))
    }
}