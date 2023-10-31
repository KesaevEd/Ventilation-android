package com.mvptest.presentation.ui.calculation.calculators.conditioner

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.calculation.ventilationconstans.equipmentsList
import com.mvptest.presentation.ui.calculation.ventilationconstans.heatLevelList
import com.mvptest.presentation.ui.calculation.ventilationconstans.lightLevelList
import com.mvptest.presentation.ui.calculation.ventilationconstans.peopleRadiations
import com.mvptest.presentation.ui.calculation.ventilationconstans.sunRadiationList
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.domain.models.CalculationType
import com.mvptest.presentation.ui.common.CalculatorsResult
import com.mvptest.presentation.ui.common.PairObjectsDropDown
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.ShortPairObjectsDropDown
import com.mvptest.presentation.ui.common.TextTitle
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun ConditionerScreen(isFromProject: String, onBackPressed: () -> Unit, onSaveClicked: () -> Unit) {

    var peopleBehaviors by remember { mutableStateOf("") }

    var peopleRadiation by remember {
        mutableIntStateOf(value = 0)
    }

    var peopleCount by remember {
        mutableStateOf(value = "")
    }

    var lightLevelText by remember { mutableStateOf("") }

    var lightLevel by remember {
        mutableIntStateOf(value = 0)
    }

    var heatLevelText by remember { mutableStateOf("") }

    var heatLevel by remember {
        mutableIntStateOf(value = 0)
    }

    var roomArea by remember {
        mutableStateOf(value = "")
    }

    var roomHeight by remember {
        mutableStateOf(value = "")
    }

    var sunLevelText by remember { mutableStateOf("") }

    var sunLevel by remember {
        mutableIntStateOf(value = 0)
    }

    val equipmentList = remember {
        mutableStateListOf(EquipItem("", 0, ""))
    }

    var isResult by remember {
        mutableStateOf(value = false)
    }
    var conditionerResult by remember {
        mutableStateOf(value = CalculationResult(CalculationType.CONDITIONER, ""))
    }

    var isSomethingWrong by remember {
        mutableStateOf(value = false)
    }


    LazyColumn(
        modifier = Modifier
            .padding(18.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.sand),
                        shape = RoundedCornerShape(25.dp)
                    )
            ) {
                TextTitle(
                    modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp),
                    text = stringResource(id = R.string.diffusers_title),
                    colorId = R.color.white
                )
            }

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.people_radiations
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
            ) {
                PairObjectsDropDown(
                    R.string.choose_variant,
                    peopleRadiations,
                    onItemClick = { behaviors, radiations ->
                        isResult = false
                        isSomethingWrong = false
                        peopleBehaviors = behaviors
                        peopleRadiation = radiations
                    })
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 25.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "image",
                    tint = colorResource(
                        id = R.color.gray
                    )
                )
            }

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.people_count
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                value = peopleCount,
                onValueChange = { text ->
                    isResult = false
                    isSomethingWrong = false
                    peopleCount = text
                },
                hint = stringResource(id = R.string.enter_value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.light_level
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
            ) {
                PairObjectsDropDown(
                    R.string.choose_variant,
                    lightLevelList,
                    onItemClick = { text, value ->
                        isResult = false
                        isSomethingWrong = false
                        lightLevelText = text
                        lightLevel = value
                    })
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 25.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "image",
                    tint = colorResource(
                        id = R.color.gray
                    )
                )
            }

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.heat_level
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
            ) {
                PairObjectsDropDown(
                    R.string.choose_variant,
                    heatLevelList,
                    onItemClick = { text, value ->
                        isResult = false
                        isSomethingWrong = false
                        heatLevelText = text
                        heatLevel = value
                    })
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 25.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "image",
                    tint = colorResource(
                        id = R.color.gray
                    )
                )
            }

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.room_area
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                value = roomArea,
                onValueChange = { text ->
                    isResult = false
                    isSomethingWrong = false
                    roomArea = text
                },
                hint = stringResource(id = R.string.enter_value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.room_height
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                value = roomHeight,
                onValueChange = { text ->
                    isResult = false
                    isSomethingWrong = false
                    roomHeight = text
                },
                hint = stringResource(id = R.string.enter_value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.sun_radiations
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
            ) {
                PairObjectsDropDown(
                    R.string.choose_variant,
                    sunRadiationList,
                    onItemClick = { text, value ->
                        isResult = false
                        isSomethingWrong = false
                        sunLevelText = text
                        sunLevel = value
                    })
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 25.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "image",
                    tint = colorResource(
                        id = R.color.gray
                    )
                )
            }

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.equipment_radiations
            )
        }

        items(equipmentList) { item ->
            EquipItem(item = item, onValueChange = { newItem ->
                isResult = false
                isSomethingWrong = false
                val index = equipmentList.indexOf(item)
                equipmentList[index] = newItem
            }, onDeleteClicked = { })
        }

        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .align(Alignment.Center),
                    shape = RoundedCornerShape(8.dp),
                    content = {
                        Row(modifier = Modifier) {
                            Icon(
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .align(Alignment.CenterVertically)
                                    .height(20.dp)
                                    .width(20.dp),
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = "image",
                                tint = Color.White,
                            )
                            Text(
                                text = stringResource(id = R.string.add_equipment),
                                modifier = Modifier
                                    .padding(start = 15.dp, end = 6.dp),
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center,
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    },
                    onClick = {
                        isResult = false
                        isSomethingWrong = false
                        equipmentList.add(EquipItem("", 0, ""))
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
                )
            }


            if (isResult) {
                CalculatorsResult(
                    calculationResult = conditionerResult
                )
            }

            if (isSomethingWrong) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(id = R.string.something_wrong_calculation),
                    fontFamily = interFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.red)
                )
            }

            Row(modifier = Modifier.padding(top = 30.dp, bottom = 15.dp)) {
                Button(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp),
                    onClick = { onBackPressed() },
                    border = BorderStroke(
                        1.dp,
                        color = colorResource(id = R.color.dark_gray_2)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                    content = {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .width(60.dp),
                            painter = painterResource(id = R.drawable.ic_arrow_left),
                            contentDescription = "image",
                            tint = colorResource(id = R.color.dark_gray_2),
                        )
                    }
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = 10.dp),
                    shape = RoundedCornerShape(16.dp),
                    content = {
                        Row(modifier = Modifier) {
                            if (isResult && isFromProject == "true") {
                                Icon(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .height(11.dp)
                                        .width(14.dp),
                                    painter = painterResource(id = R.drawable.ic_check),
                                    contentDescription = "image",
                                    tint = Color.White,
                                )
                            } else {
                                Icon(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .height(14.dp)
                                        .width(14.dp),
                                    painter = painterResource(id = R.drawable.ic_calculator),
                                    contentDescription = "image",
                                    tint = Color.White,
                                )
                            }
                            Text(
                                text = if (isResult && isFromProject == "true") stringResource(id = R.string.save_button) else stringResource(
                                    id = R.string.calculating
                                ),
                                modifier = Modifier
                                    .padding(start = 15.dp),
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    onClick = {
                        if (!isResult || isFromProject == "false") {
                            val calculatorHelper = ConditionerHelper(
                                peopleRadiation = peopleRadiation,
                                peopleCount = peopleCount,
                                lightLevel = lightLevel,
                                heatLevel = heatLevel,
                                roomArea = roomArea,
                                roomHeight = roomHeight,
                                sunRadiation = sunLevel,
                                equipments = equipmentList.map {
                                    it.volume * it.count.toInt()
                                }
                            )
                            val result = calculatorHelper.calculate()

                            if (result != null) {
                                conditionerResult = result
                                isResult = true
                            } else {
                                isSomethingWrong = true
                            }

                        } else {
                            if (isFromProject == "true") {
                                onSaveClicked()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
                )
            }
        }
    }
}


@Composable
fun EquipItem(
    item: EquipItem,
    onValueChange: (item: EquipItem) -> Unit,
    onDeleteClicked: (item: EquipItem) -> Unit
) {
    var equipItem = item
    Row(modifier = Modifier.padding(top = 5.dp)) {
        Box(modifier = Modifier.width(250.dp)) {
            ShortPairObjectsDropDown(
                hintId = R.string.choose_variant,
                list = equipmentsList,
                onItemClick = { text, value ->
                    equipItem = item.copy(volume = value)
                    onValueChange(equipItem)
                }, isMaxWidth = false
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 25.dp),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "image",
                tint = colorResource(
                    id = R.color.gray
                )
            )
        }
        RoundedTextField(
            modifier = Modifier
                .padding(start = 10.dp),
            value = item.count,
            onValueChange = { text ->
                equipItem = item.copy(count = text)
                onValueChange(equipItem)
            },
            hint = stringResource(id = R.string.counts),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

data class EquipItem(
    val name: String,
    val volume: Int,
    val count: String
)