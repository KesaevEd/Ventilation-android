package com.mvptest.presentation.ui.calculation.ventilationconstans

import com.mvptest.presentation.ui.calculation.calculators.aerodynamic.AerodynamicElement

val ventElements = arrayOf(
    AerodynamicElement(name = "Колено с острыми кромками 30°", area = 0, pressureLoss = 3.2),
    AerodynamicElement(name = "Колено с острыми кромками 45°", area = 0, pressureLoss = 2.6),
    AerodynamicElement(name = "Колено с острыми кромками 60°", area = 0, pressureLoss = 2.2),
    AerodynamicElement(name = "Колено с острыми кромками 90°", area = 0, pressureLoss = 1.2),
    AerodynamicElement(name = "Колено с острыми кромками 120°", area = 0, pressureLoss = 0.56),
    AerodynamicElement(name = "Колено с острыми кромками 150°", area = 0, pressureLoss = 0.16),
    AerodynamicElement(name = "Отвод 45°", area = 0, pressureLoss = 0.1),
    AerodynamicElement(name = "Отвод 90°", area = 0, pressureLoss = 0.17),
    AerodynamicElement(name = "Колено Z-образное 90°", area = 0, pressureLoss = 4.0),
    AerodynamicElement(name = "Колено П-образное 90°", area = 0, pressureLoss = 2.3),
    AerodynamicElement(name = "Тройник на проходе (нагнетание)", area = 0, pressureLoss = 0.3),
    AerodynamicElement(name = "Тройник на проходе (всасывание)", area = 0, pressureLoss = 0.75),
    AerodynamicElement(name = "Тройник на ответвлении (нагнетание)", area = 0, pressureLoss = 1.3),
    AerodynamicElement(name = "Тройник на ответвлении (всасывание)", area = 0, pressureLoss = 0.4),
    AerodynamicElement(name = "Диффузор конический", area = 0, pressureLoss = 0.2),
    AerodynamicElement(name = "Диффузор пирамидальный", area = 0, pressureLoss = 0.24),
    AerodynamicElement(name = "Конфузор", area = 0, pressureLoss = 0.3),
    AerodynamicElement(name = "Расширение", area = 0, pressureLoss = 1.0),
    AerodynamicElement(name = "Сужение", area = 0, pressureLoss = 0.5),
    AerodynamicElement(name = "Конический коллектор", area = 0, pressureLoss = 0.4),
    AerodynamicElement(name = "Прямой канал с сеткой или решеткой", area = 0, pressureLoss = 1.4),
    AerodynamicElement(name = "Первое боковое отверстие", area = 0, pressureLoss = 3.5),
    AerodynamicElement(name = "Среднее боковое отверстие", area = 0, pressureLoss = 1.3),
    AerodynamicElement(name = "Последнее боковое отверстие", area = 0, pressureLoss = 4.5),
    AerodynamicElement(name = "Приточная шахта с зонтом", area = 0, pressureLoss = 1.3),
    AerodynamicElement(name = "Приточная шахта с зонтом", area = 0, pressureLoss = 1.2),
    AerodynamicElement(name = "Решетка щелевая типа Р", area = 0, pressureLoss = 2.0),
    AerodynamicElement(
        name = "Воздухораспределитель для подачи воздуха компактной струей типа ВГК",
        area = 0,
        pressureLoss = 1.9
    ),
    AerodynamicElement(
        name = "Воздухораспределитель приколонный регулируемый типа НРВ",
        area = 0,
        pressureLoss = 3.0
    ),
    AerodynamicElement(
        name = "Воздухораспределитель для сосредоточенной подачи воздуха типа ВСП",
        area = 0,
        pressureLoss = 2.5
    ),
    AerodynamicElement(
        name = "Воздухораспределитель регулируемого типа ВР",
        area = 0,
        pressureLoss = 1.6
    ),
    AerodynamicElement(name = "Решетка унифицированная типа РВ", area = 0, pressureLoss = 1.9),
    AerodynamicElement(
        name = "Воздухораспределитель вихревой регулируемый типа ВВР",
        area = 0,
        pressureLoss = 1.75
    ),
    AerodynamicElement(name = "Дроссель клапан", area = 0, pressureLoss = 5.0),
    AerodynamicElement(name = "Шибер", area = 0, pressureLoss = 3.0),
    AerodynamicElement(name = "Диафрагма на прямом участке", area = 0, pressureLoss = 0.7),
    AerodynamicElement(name = "Плафон (анемостат) СТ-КР, СТ-КВ", area = 0, pressureLoss = 5.6),
    AerodynamicElement(
        name = "Решетка регулируемая РС-ВГ (приточная)",
        area = 0,
        pressureLoss = 3.8
    ),
    AerodynamicElement(name = "Решетка нерегулируемая РС-Г", area = 0, pressureLoss = 2.9)
)

val ductSizeListAerodynamic = arrayListOf(
    "100*100/d100",
    "100*200/d133",
    "100*300/d150",
    "100*400/d160",
    "100*500/d167",
    "100*600/d171",
    "150*150/d150",
    "200*150/d171",
    "250*150/d189",
    "300*150/d200",
    "400*150/d218",
    "500*150/d231",
    "600*150/d240",
    "700*150/d247",
    "800*150/d253",
    "200*200/d200",
    "300*200/d240",
    "400*200/d267",
    "500*200/d286",
    "600*200/d300",
    "700*200/d311",
    "800*200/d320",
    "900*200/d327",
    "1000*200/d333",
    "300*300/d300",
    "400*300/d343",
    "500*300/d375",
    "600*300/d400",
    "700*300/d420",
    "800*300/d436",
    "900*300/d450",
    "1000*300/d462",
    "1200*1600/d1370"
)