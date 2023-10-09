package com.mvptest.presentation.ui.newroom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.domain.models.HeaterType
import com.mvptest.presentation.ui.common.BackOrSaveRow
import com.mvptest.presentation.ui.common.CalculatingButton
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.presentation.ui.newproject.NewProjectViewModel
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R
import java.util.IdentityHashMap

@Composable
fun NewRoomScreenThird(
    newRoomViewModel: NewRoomViewModel,
    newProjectViewModel: NewProjectViewModel,
    onBackPressed: () -> Unit,
    onSaveRoomClicked: (projectId: String) -> Unit
) {

    val heaterTypes = listOf(HeaterType.NONE, HeaterType.WATER, HeaterType.ELECTRICITY)
    val heaterNames = listOf(
        stringResource(id = R.string.no_heater),
        stringResource(id = R.string.water_heater),
        stringResource(id = R.string.electro_heater)
    )

    var airExchangePerformance by remember {
        mutableStateOf(value = newRoomViewModel.state.airExchangePerformance ?: "")
    }

    var pressureLoss by remember {
        mutableStateOf(value = newRoomViewModel.state.pressureLoss ?: "")
    }

    var airDuctArea by remember {
        mutableStateOf(value = newRoomViewModel.state.airDuctArea ?: "")
    }

    var heaterType by remember {
        mutableStateOf(value = HeaterType.NONE)
    }

    var heaterPerformance by remember {
        mutableStateOf(value = newRoomViewModel.state.heaterPerformance ?: "")
    }

    var isAirConditioner by remember {
        mutableStateOf(value = newRoomViewModel.state.isAirConditioner ?: false)
    }

    var airConditionerPerformance by remember {
        mutableStateOf(value = newRoomViewModel.state.airConditionerPerformance ?: "")
    }

    var selectedHeaterButtonIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.dark_blue),
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Column(modifier = Modifier.padding(start = 25.dp, bottom = 25.dp, top = 25.dp)) {
                Text(
                    modifier = Modifier.padding(),
                    text = newRoomViewModel.state.title ?: "",
                    fontSize = 22.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = newProjectViewModel.state.address ?: "",
                    fontSize = 16.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 20.dp),
            textId = R.string.air_exchange_performance
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = airExchangePerformance.toString(),
                onValueChange = {
                    newRoomViewModel.setAirExchangePerformance(it.toInt())
                    airExchangePerformance = it
                },
                hint = stringResource(id = R.string.value_m3),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp)
            ) {}
        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.pressure_loss_and_air_area
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = pressureLoss.toString(),
            onValueChange = {
                newRoomViewModel.setPressureLoss(it.toInt())
                pressureLoss = it
            },
            hint = stringResource(id = R.string.pressure_loss),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = airDuctArea.toString(),
            onValueChange = {
                newRoomViewModel.setAirDuctArea(it.toInt())
                airDuctArea = it
            },
            hint = stringResource(id = R.string.air_duct_area),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        CalculatingButton(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 15.dp, top = 10.dp)
        ) {}

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.heater_type
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
                for (index in 0..2) {
                    Button(
                        onClick = {
                            heaterType = heaterTypes[index]
                            selectedHeaterButtonIndex = index
                            newRoomViewModel.setHeaterType(heaterTypes[index])
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
                            backgroundColor = if (selectedHeaterButtonIndex == index) colorResource(
                                id = R.color.dark_gray_2
                            ) else colorResource(id = R.color.light_gray),
                            contentColor = if (selectedHeaterButtonIndex == index) Color.White else colorResource(
                                id = R.color.gray
                            )
                        ),
                        content = {
                            Text(
                                modifier = Modifier.fillMaxHeight(),
                                text = heaterNames[index],
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    )
                }
            }
        }

        if (heaterType != HeaterType.NONE) {
            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.heater_performance
            )
            Box(modifier = Modifier.padding(top = 5.dp)) {
                RoundedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = heaterPerformance.toString(),
                    onValueChange = {
                        newRoomViewModel.setHeaterPerformance(it.toInt())
                        heaterPerformance = it
                    },
                    hint = stringResource(id = R.string.value_kvt),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                CalculatingButton(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 15.dp)
                ) {}
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .background(
                    colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.air_conditioner),
                    modifier = Modifier.padding(start = 25.dp, top = 21.dp, bottom = 21.dp)
                )
                Spacer(Modifier.weight(1f))
                RadioButton(
                    modifier = Modifier.padding(end = 15.dp),
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = colorResource(id = R.color.dark_gray),
                        selectedColor = colorResource(
                            id = R.color.dark_gray
                        )
                    ),
                    selected = isAirConditioner,
                    onClick = {
                        isAirConditioner = !isAirConditioner
                        newRoomViewModel.setIsAirConditioner(isAirConditioner)
                    })
            }
        }

        if (isAirConditioner) {
            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.air_conditioner_performance
            )
            Box(modifier = Modifier.padding(top = 5.dp)) {
                RoundedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = airConditionerPerformance.toString(),
                    onValueChange = {
                        newRoomViewModel.setAirConditionerPerformance(it.toInt())
                        airConditionerPerformance = it
                    },
                    hint = stringResource(id = R.string.value_kvt),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                CalculatingButton(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 15.dp)
                ) {}
            }
        }

        BackOrSaveRow(onBackPressed = { onBackPressed() }, onSaveClick = {
            newRoomViewModel.saveRoom(projectId = newProjectViewModel.projectId)
            newRoomViewModel.clearState()
            onSaveRoomClicked(newProjectViewModel.projectId)
        })

    }

}
