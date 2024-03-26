package com.mvptest.presentation.ui.calculation.calculators.airductarea

import kotlin.math.sqrt

// Площадь воздуховода круглого сечения
fun calculateDuctworkRoundArea(length: Double, diameter: Double): String = (
    length *
        diameter * Math.PI / 1000
    ).toString()

// Площадь воздуховода прямоугольного сечения
fun calculateDuctworkRectangleArea(length: Double, width: Double, height: Double): String = (
    length *
        (width + height) * 2 / 1000
    ).toString()

// Площадь отвода круглого сечения
fun calculateTapRoundArea(angle: String, diameter: Double): String {
    val elementNumber =
        if (angle == "90" || angle == "60") 2 else 0

    val ratio = when (angle) {
        "90" -> 2
        "60" -> 3
        "45" -> 4
        "30" -> 6
        "15" -> 12
        else -> 0
    }

    val neck = (Math.PI / ratio * diameter / 2) / (elementNumber + 2) + 15
    val section = Math.PI / ratio * diameter / (elementNumber * 2 + 2)

    val tapRoundSquare1 = Math.PI * diameter / 1000 * 0.1
    val tapRoundSquare2 =
        (Math.PI * diameter * (2 * (neck + section / 2) + elementNumber * (neck + section))) / 1000000

    return (tapRoundSquare1 + tapRoundSquare2).toString()
}

// Площадь отвода прямоугольного сечения
fun calculateTapRectangularArea(angle: String, width: Double, height: Double): String {
    val w = width / 1000
    val h = height / 1000
    return ((w + h) * 0.2 + Math.PI * (((0.125 + w) * (0.125 + w)) - (0.125 * 0.125)) * angle.toInt() * 2 / 360 + Math.PI * 0.125 * angle.toInt() * h / 180 + Math.PI * (0.125 + w) * angle.toInt() * h / 180).toString()
}

// Площадь перехода круглое на круглое сечение
fun calculateTransitionRoundRoundArea(
    diameter1: Double,
    diameter2: Double,
    length: Double,
): String {
    val d1 = diameter1 / 1000
    val d2 = diameter2 / 1000
    val l = length / 1000

    return (Math.PI * Math.sqrt(l * l + ((d1 - d2) / 2) * ((d1 - d2) / 2)) * (d1 / 2 + d2 / 2) + Math.PI * d1 * 0.05 + Math.PI * d2 * 0.05).toString()
}

// Площадь перехода прямоугольное на прямоугольное сечение
fun calculateTransitionRectangularRectangularSquare(
    width1: Double,
    width2: Double,
    height1: Double,
    height2: Double,
    length: Double,
): String {
    val w1 = width1 / 1000
    val w2 = width2 / 1000
    val h1 = height1 / 1000
    val h2 = height2 / 1000
    val l = length / 1000

    val ratioWidth =
        sqrt(((h1 - h2) / 2) * ((h1 - h2) / 2) + (l * l))
    val ratioHeight = sqrt(
        ((w1 - w2) / 2) * ((w1 - w2) / 2) + (l * l),
    )

    return (2 * (w1 + w2) / 2 * ratioWidth + 2 * (h1 + h2) / 2 * ratioHeight + (2 * w2 + 2 * h2 + 2 * w1 + 2 * h1) * 0.05).toString()
}

// Площадь перехода круглого на прямоугольное сечение
fun calculateTransitionRoundRectangularArea(
    width: Double,
    height: Double,
    diameter: Double,
    length: Double,
): String {
    return (((width + height) * 2.8 + 3.14 * diameter) / 2 * length / 1000000).toString()
}

// Площадь врезки прямой круглой
fun calculateIncutStraightRoundArea(
    diameter: Double,
    length: Double,
): String {
    return (((diameter + 0.02) * Math.PI * length) / 1000000).toString()
}

// Площадь врезки прямой прямоугольной
fun calculateIncutStraightRectangularArea(
    width: Double,
    height: Double,
    length: Double,
): String {
    return (((width + length + 0.04) * 2 * height) / 1000000).toString()
}

// Площадь круглой врезки с воротником
fun calculateIncutCollarRoundArea(
    diameter1: Double,
    diameter2: Double,
    length: Double,
): String {
    return ((diameter1 * Math.PI * length / 1000000) + (diameter2 * Math.PI / 4 / 1000 * (diameter1 + 100) / 1000)).toString()
}

// Площадь прямоугольной врезки с воротником
fun calculateIncutCollarRectangularArea(
    width: Double,
    height: Double,
    diameter: Double,
    length: Double,
): String {
    return (((width + length) * 2 * height) + (diameter * Math.PI / 3 * (width + 100)) / 1000000).toString()
}

// Площадь тройника круглого в круглое сечение
fun calculateTeeIncutRoundRoundArea(
    diameter1: Double,
    diameter2: Double,
    length1: Double,
    length2: Double,
): String {
    val d1 = diameter1 / 1000
    val d2 = diameter2 / 1000
    val l1 = length1 / 1000
    val l2 = length2 / 1000

    return (Math.PI * d1 * l1 + Math.PI * d2 * l2).toString()
}

// Площадь тройника прямоугольного в круглое  сечение
fun calculateTeeIncutArea(
    width: Double,
    height: Double,
    diameter: Double,
    length1: Double,
    length2: Double,
): String {
    val d = diameter / 1000
    val w = width / 1000
    val h = height / 1000
    val l1 = length1 / 1000
    val l2 = length2 / 1000

    return (Math.PI * d * l1 + (w + h) * 2 * l2).toString()
}

// Площадь тройника круглого в прямоугольное сечение
fun calculateTeeOutputRectangularRoundArea(
    width: Double,
    height: Double,
    diameter: Double,
    length1: Double,
    length2: Double,
): String {
    val w = width / 1000
    val h = height / 1000
    val d = diameter / 1000
    val l1 = length1 / 1000
    val l2 = length2 / 1000

    return ((w + h) * 2 * l1 + Math.PI * d * l2 - Math.PI * d * d / 4).toString()
}

// Площадь тройника прямоугольного в прямоугольное сечение
fun calculateTeeOutputRectangularRectangularArea(
    width1: Double,
    width2: Double,
    height1: Double,
    height2: Double,
    length1: Double,
    length2: Double,
): String {
    val w1 = width1 / 1000
    val h1 = height1 / 1000
    val l1 = length1 / 1000
    val w2 = width2 / 1000
    val h2 = height2 / 1000
    val l2 = length2 / 1000

    return ((w1 + h1) * 2 * l1 + (w2 + h2) * 2 * l2 - w2 * h2).toString()
}

// Площадь заглушки круглого сечения
fun cupRoundArea(diameter: Double): String =
    (Math.PI * diameter / 1000 * diameter / 1000 / 4 + (Math.PI * diameter / 1000) * 0.05).toString()

// Площадь заглушки прямоугольного сечения
fun cupRectangleArea(width: Double, height: Double): String =
    (width / 1000 * height / 1000 + (width / 1000 + height / 1000) * 0.05).toString()

// Площадь утки со смещением в 1-ой плоскости
fun calculateDuckOneArea(
    width: Double,
    height: Double,
    shift: Double,
    length: Double,
): String {
    val w = width / 1000
    val h = height / 1000
    val l = length / 1000
    val s = shift / 1000

    return (2 * (w * sqrt(l * l + s * s) + h * l + 0.1 * (w + h))).toString()
}

// Площадь утки со смещением в 2-х плоскостях
fun calculateDuckTwoArea(
    width: Double,
    height: Double,
    shift1: Double,
    shift2: Double,
    length: Double,
): String {
    val w = width / 1000
    val h = height / 1000
    val l = length / 1000
    val s1 = shift1 / 1000
    val s2 = shift2 / 1000

    return (
        2 * (
            h * sqrt(l * l + s2 * s2) + w * sqrt(
                l * l + s1 * s1,
            ) + 0.1 * (w + h)
            )
        ).toString()
}

// Площадь зонта островного типа
fun calculateCanopySharpArea(
    width1: Double,
    width2: Double,
    height1: Double,
    height2: Double,
    shift: Double,
): String {
    val w1 = width1 / 1000
    val w2 = width2 / 1000
    val h1 = height1 / 1000
    val h2 = height2 / 1000
    val s = shift / 1000
    val SA = sqrt(((h1 - h2) / 2) * ((h1 - h2) / 2) + (s * s))
    val SB = sqrt((w1 - w2) / 2 * (w1 - w2) / 2 + (s * s))

    return (2 * (w1 + w2) / 2 * SA + 2 * (h1 + h2) / 2 * SB + w2 * h2).toString()
}

// Площадь зонта пристенного типа
fun calculateCanopyBluntArea(
    width: Double,
    height: Double,
    board: Double,
    length: Double,
): String {
    val w = width / 1000
    val h = height / 1000
    val b = board / 1000
    val l = length / 1000

    return (height * (width + board) + length * sqrt((width - board) * (width - board) + (height * height)) + length * height + length * board).toString()
}
