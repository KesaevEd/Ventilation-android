package com.mvptest.presentation.ui.calculation.calculators.airductarea

import com.mvptest.ventilation.R

sealed class AirDuctType() {

    abstract fun toAirDuctElement(): AirDuctElement

    data class DuctworkRoundArea(
        val length: Double? = null,
        val diameter: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) :
        AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.ductwork_round_area,
                iconId = R.drawable.ductwork_round_correction__1_,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class DuctworkRectangleArea(
        val length: Double? = null,
        val width: Double? = null,
        val height: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) :
        AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.ductwork_rectangle_area,
                iconId = R.drawable.ductwork_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TapRoundArea(
        val angle: String? = null,
        val diameter: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) :
        AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tap_round_area,
                iconId = R.drawable.tap_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TapRectangularArea(
        val angle: String? = null,
        val width: Double? = null,
        val height: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) :
        AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tap_rectangular_area,
                iconId = R.drawable.tap_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TransitionRoundRoundArea(
        val diameter1: Double? = null,
        val diameter2: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.transition_round_round_area,
                iconId = R.drawable.transition_round_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TransitionRectangularRectangularArea(
        val width1: Double? = null,
        val width2: Double? = null,
        val height1: Double? = null,
        val height2: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.transition_rectangular_rectangular_area,
                iconId = R.drawable.transition_rectangular_rectangular,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TransitionRoundRectangularArea(
        val width: Double? = null,
        val height: Double? = null,
        val diameter: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.transition_round_rectangular_area,
                iconId = R.drawable.transition_round_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class IncutStraightRoundArea(
        val diameter: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.incut_straight_round_area,
                iconId = R.drawable.incut_straight_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class IncutStraightRectangularArea(
        val width: Double? = null,
        val height: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.incut_straight_rectangular_area,
                iconId = R.drawable.incut_straight_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class IncutCollarRoundArea(
        val diameter1: Double? = null,
        val diameter2: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.incut_collar_round_area,
                iconId = R.drawable.incut_collar_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class IncutCollarRectangularArea(
        val width: Double? = null,
        val height: Double? = null,
        val diameter: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.incut_collar_rectangular_area,
                iconId = R.drawable.incut_collar_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TeeIncutRoundRoundArea(
        val diameter1: Double? = null,
        val diameter2: Double? = null,
        val length1: Double? = null,
        val length2: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tee_incut_round_round_area,
                iconId = R.drawable.tee_output_round_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TeeIncutArea(
        val width: Double? = null,
        val height: Double? = null,
        val diameter: Double? = null,
        val length1: Double? = null,
        val length2: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tee_incut_area,
                iconId = R.drawable.tee_incut_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TeeOutputRectangularRoundArea(
        val width: Double? = null,
        val height: Double? = null,
        val diameter: Double? = null,
        val length1: Double? = null,
        val length2: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tee_output_rectangular_round_area,
                iconId = R.drawable.tee_output_rectangular_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class TeeOutputRectangularRectangularArea(
        val width1: Double? = null,
        val width2: Double? = null,
        val height1: Double? = null,
        val height2: Double? = null,
        val length1: Double? = null,
        val length2: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.tee_output_rectangular_rectangular_area,
                iconId = R.drawable.tee_output_rectangular_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class RoundArea(
        val diameter: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.cup_round_area,
                iconId = R.drawable.cap_round_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class CupRectangleArea(
        val width: Double? = null,
        val height: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) :
        AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.cup_rectangle_area,
                iconId = R.drawable.cap_rectangular_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class DuckOneArea(
        val width: Double? = null,
        val height: Double? = null,
        val shift: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.duck_one_area,
                iconId = R.drawable.duck_one_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class DuckTwoArea(
        val width: Double? = null,
        val height: Double? = null,
        val shift1: Double? = null,
        val shift2: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.duck_two_area,
                iconId = R.drawable.duck_two_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class CanopySharpArea(
        val width1: Double? = null,
        val width2: Double? = null,
        val height1: Double? = null,
        val height2: Double? = null,
        val shift: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.canopy_sharp_area,
                iconId = R.drawable.canopy_sharp_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }

    data class CanopyBluntArea(
        val width: Double? = null,
        val height: Double? = null,
        val board: Double? = null,
        val length: Double? = null,
        val area: Double? = null,
        val count: Int? = null,
    ) : AirDuctType() {
        override fun toAirDuctElement(): AirDuctElement {
            return AirDuctElement(
                titleId = R.string.canopy_blunt_area,
                iconId = R.drawable.canopy_blunt_correction,
                description = "",
                area = area.toString(),
                count = count,
            )
        }
    }
}

data class AirDuctElement(
    val titleId: Int? = null,
    val iconId: Int? = null,
    val description: String? = null,
    val area: String? = null,
    val count: Int? = null,
)

data class AirDuctShortItem(
    val title: Int,
    val iconId: Int,
    val route: String,
)

val airDuctShortItemList = listOf(
    AirDuctShortItem(R.string.ductwork_round_area, R.drawable.ductwork_round_correction__1_, "ductwork_round_area"),
    AirDuctShortItem(R.string.ductwork_rectangle_area, R.drawable.ductwork_rectangular_correction, "ductwork_rectangle_area"),
    AirDuctShortItem(R.string.tap_round_area, R.drawable.tap_round_correction, "tap_round_area"),
    AirDuctShortItem(R.string.tap_rectangular_area, R.drawable.tap_rectangular_correction, "tap_rectangular_area"),
    AirDuctShortItem(R.string.transition_round_round_area, R.drawable.transition_round_round_correction, "transition_round_round_area"),
    AirDuctShortItem(R.string.transition_rectangular_rectangular_area, R.drawable.transition_rectangular_rectangular, "transition_rectangular_rectangular_area"),
    AirDuctShortItem(R.string.transition_round_rectangular_area, R.drawable.transition_round_rectangular_correction, "transition_round_rectangular_area"),
    AirDuctShortItem(R.string.incut_straight_round_area, R.drawable.incut_straight_round_correction, "incut_straight_round_area"),
    AirDuctShortItem(R.string.incut_straight_rectangular_area, R.drawable.incut_straight_rectangular_correction, "incut_straight_rectangular_area"),
    AirDuctShortItem(R.string.incut_collar_round_area, R.drawable.incut_collar_round_correction, "incut_collar_round_area"),
    AirDuctShortItem(R.string.incut_collar_rectangular_area, R.drawable.incut_collar_rectangular_correction, "incut_collar_rectangular_area"),
    AirDuctShortItem(R.string.tee_incut_round_round_area, R.drawable.tee_output_round_round_correction, "tee_incut_round_round_area"),
    AirDuctShortItem(R.string.tee_incut_area, R.drawable.tee_incut_correction, "tee_incut_area"),
    AirDuctShortItem(R.string.tee_output_rectangular_round_area, R.drawable.tee_output_rectangular_round_correction, "tee_output_rectangular_round_area"),
    AirDuctShortItem(R.string.tee_output_rectangular_rectangular_area, R.drawable.tee_output_rectangular_rectangular_correction, "tee_output_rectangular_rectangular_area"),
    AirDuctShortItem(R.string.cup_round_area, R.drawable.cap_round_correction, "cup_round_area"),
    AirDuctShortItem(R.string.cup_rectangle_area, R.drawable.cap_rectangular_correction, "cup_rectangle_area"),
    AirDuctShortItem(R.string.duck_one_area, R.drawable.duck_one_correction, "duck_one_area"),
    AirDuctShortItem(R.string.duck_two_area, R.drawable.duck_two_correction, "duck_two_area"),
    AirDuctShortItem(R.string.canopy_sharp_area, R.drawable.canopy_sharp_correction, "canopy_sharp_area"),
    AirDuctShortItem(R.string.canopy_blunt_area, R.drawable.canopy_blunt_correction, "canopy_blunt_area")
)
