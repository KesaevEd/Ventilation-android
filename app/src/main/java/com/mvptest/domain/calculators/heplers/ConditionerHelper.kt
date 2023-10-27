package com.mvptest.domain.calculators.heplers

import com.mvptest.data.ventilationconstans.lightLevelList
import com.mvptest.data.ventilationconstans.peopleRadiations
import com.mvptest.domain.calculators.CalculationResult
import com.mvptest.domain.models.CalculationType

class ConditionerHelper(
    val peopleRadiation: Int? = null,
    val peopleCount: String? = null,
    val lightLevel: Int? = null,
    val heatLevel: Int? = null,
    val roomArea: String? = null,
    val roomHeight: String? = null,
    val sunRadiation: Int? = null,
    val equipments: List<Int>? = emptyList()
) {


    fun calculate(): CalculationResult? {
        try {
            val peopleRadiations = peopleRadiation!! * peopleCount?.toFloat()!!
            val lightLevel = lightLevel!!.toFloat() * roomArea!!.toFloat()
            val heatLevel = heatLevel!!.toFloat() * roomArea.toFloat()
            val sunRadiation =
                sunRadiation!!.toFloat() * roomArea.toFloat() * roomHeight!!.toFloat()
            val equipments = equipments!!.sum()

            val result =
                (peopleRadiations + lightLevel + heatLevel + sunRadiation + equipments) / 1000

            return CalculationResult(CalculationType.CONDITIONER, result.toString())

        } catch (e: Exception) {
            return null
        }
    }

}