package com.mpvtest.ventilation

import com.mvptest.ventilation.R

data class Figure(val image: Int, val name: String)

object Figures {
    private val images = intArrayOf(
        R.drawable.ductwork_rectangular_correction,
        R.drawable.ductwork_round_correction__1_,
        R.drawable.tap_round_correction,
        R.drawable.tap_rectangular_correction,
        R.drawable.transition_round_round_correction,
        R.drawable.transition_rectangular_rectangular,
        R.drawable.transition_round_rectangular_correction,
        R.drawable.incut_straight_round_correction,
        R.drawable.incut_straight_rectangular_correction,
        R.drawable.incut_collar_round_correction,
        R.drawable.incut_collar_rectangular_correction,
        R.drawable.tee_output_round_round_correction,
        R.drawable.tee_incut_correction,
        R.drawable.tee_output_rectangular_round_correction,
        R.drawable.tee_output_rectangular_rectangular_correction,
        R.drawable.cap_round_correction,
        R.drawable.cap_rectangular_correction,
        R.drawable.duck_one_correction,
        R.drawable.duck_two_correction,
        R.drawable.canopy_sharp_correction,
        R.drawable.canopy_blunt_correction
    )

    private val figures = arrayOf(
        "Воздуховод прямоугольного сечения",
        "Воздуховод круглого сечения",
        "Отвод круглого сечения",
        "Отвод прямоугольного сечения",
        "Переход круглого на круглое сечение",
        "Переход прямоугольного на прямоугольное сечение",
        "Переход круглого на прямоугольное сечение",
        "Врезка прямая круглая",
        "Врезка прямая прямоугольная",
        "Круглая врезка с воротником",
        "Прямоугольная врезка с воротником",
        "Тройник круглого сечения",
        "Тройник круглого сечения",
        "Тройник прямоугольного сечения",
        "Тройник прямоугольного сечения",
        "Заглушка круглого сечения",
        "Заглушка прямоугольного сечения",
        "Утка со смещением в 1-ой плоскости",
        "Утка со смещением в 2-х плоскостях",
        "Зонт островного типа",
        "Зонт пристенного типа"
    )

    var list: ArrayList<Figure>? = null
        get() {
            if (field != null)
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val figureName = figures[i]

                val figure = Figure(imageId, figureName)
                field!!.add(figure)
            }
            return field

        }
}
