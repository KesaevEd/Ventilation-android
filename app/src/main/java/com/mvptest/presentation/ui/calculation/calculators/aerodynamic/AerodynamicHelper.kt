package com.mvptest.presentation.ui.calculation.calculators.aerodynamic

import com.mvptest.presentation.ui.calculation.ventilationconstans.airDuctSizes

class AerodynamicHelper {
fun calculateCut(airFlow: String, airSpeed: Int): String{
    var rectCut = ""

    val calculatingCutArea = airFlow.toFloat() / (3600 * airSpeed.toFloat())

    for (size in airDuctSizes) {
        val currentCutArea = getCutArea(size)

        if (airDuctSizes.indexOf(size) == 0 && calculatingCutArea < currentCutArea) {

            rectCut = airDuctSizes[0]

        } else if (size == airDuctSizes.last() && (calculatingCutArea > currentCutArea)) {

            rectCut = airDuctSizes.last()

        } else if (currentCutArea < calculatingCutArea && calculatingCutArea < getNextSize(size)
        ) {
            if ((calculatingCutArea - currentCutArea) < (getNextSize(size) - calculatingCutArea)
            ) {
                rectCut = size
            } else {
                rectCut = airDuctSizes[airDuctSizes.indexOf(size) + 1]

            }
        }
    }

    return rectCut
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