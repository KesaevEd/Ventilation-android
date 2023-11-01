package com.mvptest.presentation.ui.calculation.calculators.aerodynamic

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mvptest.domain.models.CalculationType
import com.mvptest.presentation.ui.calculation.CalculationResult
import kotlin.math.pow

class AerodynamicViewModel() : ViewModel() {

    var state by mutableStateOf(AerodynamicViewState())

    fun calculate(): CalculationResult? {
        try {
            var totalMestsopr = 0.0F
            var Dekv: Float
            var Vfakt: Double
            var Re: Double
            var lamda: Double
            var Pdin: Float
            var Ptren: Float

            state.sections.forEachIndexed { index, section ->

                Dekv = getEkvDiameterFromCut(section.ductSize)

                Vfakt = getAirSpeedFact(section.airFlow, section.ductSize)

                Re = 64100 * Vfakt * Dekv

                lamda = 0.11 * (0.1 / (Dekv * 1000) + 68 / Re).pow(0.25)

                Pdin = ((Vfakt * Vfakt * 1.2) / 2).toFloat()

                Ptren = (lamda * section.length.toFloat() * Pdin / Dekv).toFloat()

                section.elements.forEach { element ->
                    totalMestsopr += element.pressureLoss.toFloat()
                }

                totalMestsopr = totalMestsopr * Pdin
                val result = Ptren + totalMestsopr

                return CalculationResult(CalculationType.AERODYNAMIC, result.toInt().toString())
            }


        } catch (e: Exception) {
            Log.e("error", "AerodynamicViewModel Error = $e")
            return null
        }
        return null
    }

    fun newSection(sectionNumber: Int) {
        val mutableList = state.sections.toMutableList()
        mutableList.add(
            AerodynamicSection(
                sectionNumber,
                "",
                "",
                "",
                listOf(AerodynamicElement("", 0, 0.0))
            )
        )
        state = state.copy(sections = mutableList)
    }

    fun deleteSection(sectionIndex: Int) {
        val newList = state.sections.toMutableList()
        newList.removeAt(sectionIndex)
        state = state.copy(sections = newList)
    }

    fun setAirFlow(index: Int, airFlow: String) {
        val list = state.sections
        list.get(index).airFlow = airFlow
        state = state.copy(sections = list)
    }

    fun setLength(index: Int, length: String) {
        val list = state.sections
        list.get(index).length = length
        state = state.copy(sections = list)
    }

    fun setDuctSize(index: Int, ductSize: String) {
        val list = state.sections
        list.get(index).ductSize = ductSize
        state = state.copy(sections = list)
    }

    fun setElement(
        indexSection: Int,
        indexElement: Int,
        newElement: AerodynamicElement
    ) {
        val list = state.sections

        val elementList = state.sections[indexSection].elements.toMutableList()
        elementList[indexElement] = newElement

        list[indexSection].elements = elementList

        state = state.copy(sections = list)
    }

    fun addElement(sectionIndex: Int) {
        val list = state.sections
        val elements = list[sectionIndex].elements.toMutableList()
        elements.add(AerodynamicElement("", 0, 0.0))
        list[sectionIndex].elements = elements
        state = state.copy(sections = list)
    }

    fun deleteElement(sectionIndex: Int, elementIndex: Int) {
        val list = state.sections
        val elements = list[sectionIndex].elements.toMutableList()

        elements.removeAt(elementIndex)
        list[sectionIndex].elements = elements
        state = state.copy(sections = list)
    }

    fun getEkvDiameterFromCut(ductSize: String): Float {
        val rect = ductSize.split("/")[0]
        val a = rect.split("*")[0].toFloat()
        val b = rect.split("*")[1].toFloat()
        return ((2 * a * b) / (1000 * (a + b)))
    }

    fun getAirSpeedFact(airFlow: String, ductSize: String): Double {
        val rect = ductSize.split("/")[0]
        val a = rect.split("*")[0].toFloat()
        val b = rect.split("*")[1].toFloat()
        return airFlow.toFloat() / (a * b * 0.0036)
    }
}

data class AerodynamicViewState(
    var sections: List<AerodynamicSection> = listOf(
        AerodynamicSection(
            0, "", "", "",  listOf(
                AerodynamicElement("", 0, 0.0)
            )
        )
    )
)

data class AerodynamicSection(
    val number: Int,
    var airFlow: String,
    var length: String,
    var ductSize: String,
    var elements: List<AerodynamicElement>
)

data class AerodynamicElement(
    val name: String,
    val area: Int,
    val pressureLoss: Double
)