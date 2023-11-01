package com.mvptest.presentation.ui.calculation.calculators.diffusers

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.mvptest.presentation.ui.calculation.ventilationconstans.airSpeedCircle
import com.mvptest.presentation.ui.calculation.ventilationconstans.airSpeedRectangle
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.domain.models.CalculationType
import com.mvptest.presentation.ui.common.AirDuctSizeDropDown
import com.mvptest.presentation.ui.common.CalculatorsResult
import com.mvptest.presentation.ui.common.PairObjectsDropDown
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextTitle
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun DiffusersScreen(
    isFromProject: String,
    onBackPressed: () -> Unit,
    onBackPressedFromProject: () -> Unit,
    onSaveClicked: () -> Unit
) {

    val diffTypes = listOf(DiffusersType.RECTANGULAR, DiffusersType.CIRCULAR)

    var diffType by remember {
        mutableStateOf(value = DiffusersType.RECTANGULAR)
    }
    var selectedDiffButtonIndex by remember { mutableIntStateOf(0) }

    var airDuctSize by remember {
        mutableStateOf(value = "")
    }

    var airDuctDiameter by remember {
        mutableStateOf(value = "")
    }

    var airFlow by remember {
        mutableStateOf(value = "")
    }

    var roomDestination by remember {
        mutableStateOf(value = "")
    }

    var airSpeed by remember {
        mutableIntStateOf(value = 0)
    }

    var isResult by remember {
        mutableStateOf(value = false)
    }
    var diffResult by remember {
        mutableStateOf(value = CalculationResult(CalculationType.DIFFUSERS, ""))
    }

    var isSomethingWrong by remember {
        mutableStateOf(value = false)
    }

    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
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
            modifier = Modifier.padding(top = 20.dp),
            textId = R.string.choose_diff_type
        )
        Box(
            modifier = Modifier
                .padding(top = 5.dp)
                .background(
                    colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Row() {
                selectedDiffButtonIndex = diffTypes.indexOf(diffType)
                for (index in 0..1) {
                    Button(
                        onClick = {
                            isResult = false
                            isSomethingWrong = false
                            diffType = diffTypes[index]
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        border = BorderStroke(
                            1.dp,
                            color = colorResource(id = R.color.gray)
                        ),
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (selectedDiffButtonIndex == index) colorResource(
                                id = R.color.dark_gray_2
                            ) else colorResource(id = R.color.light_gray),
                            contentColor = if (selectedDiffButtonIndex == index) Color.White else colorResource(
                                id = R.color.gray
                            )
                        ),
                        content = {
                            Text(
                                modifier = Modifier,
                                text = stringResource(id = diffTypes[index].textId),
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    )
                }
            }
        }

        if (diffType == DiffusersType.RECTANGULAR) {

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.air_duct_size
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
            ) {
                AirDuctSizeDropDown(onItemClick = {
                    isResult = false
                    isSomethingWrong = false
                    airDuctSize = it
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

        } else {

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.air_duct_diameter
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                value = airDuctDiameter,
                onValueChange = { text ->
                    isResult = false
                    isSomethingWrong = false
                    airDuctDiameter = text
                },
                hint = stringResource(id = R.string.enter_value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.air_flow
        )
        RoundedTextField(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(),
            value = airFlow,
            onValueChange = { text ->
                isResult = false
                isSomethingWrong = false
                airFlow = text
            },
            hint = stringResource(id = R.string.enter_value),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.room_destination
        )
        val airSpeedList =
            if (diffType == DiffusersType.RECTANGULAR) airSpeedRectangle else airSpeedCircle
        Box(
            modifier = Modifier
                .padding(top = 5.dp)
        ) {
            PairObjectsDropDown(
                R.string.room_destination,
                airSpeedList,
                onItemClick = { destination, speed ->
                    isResult = false
                    isSomethingWrong = false
                    roomDestination = destination
                    airSpeed = speed
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

        if (isResult) {
            CalculatorsResult(
                calculationResult = diffResult
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
                onClick = { if (isFromProject == "true") onBackPressedFromProject() else onBackPressed() },
                border = BorderStroke(1.dp, color = colorResource(id = R.color.dark_gray_2)),
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
                        val calculatorHelper = DiffusersHelper(
                            airDuctArea = airDuctSize,
                            airDuctDiameter = airDuctDiameter,
                            airFlow = airFlow,
                            airSpeed = airSpeed
                        )
                        val result = calculatorHelper.calculate()
                        if (result != null) {
                            diffResult = result
                            isResult = true
                        } else {
                            isSomethingWrong = true
                        }
                    } else {
                        if (isFromProject == "true") {
                            onSaveClicked()
                            onBackPressedFromProject()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        }
    }
    BackHandler {
        if (isFromProject == "true") onBackPressedFromProject() else onBackPressed()
    }
}


enum class DiffusersType(val textId: Int) {
    RECTANGULAR(R.string.rectangular_diff), CIRCULAR(R.string.circle_diff)
}