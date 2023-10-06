package com.mvptest.presentation.ui.newroom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.domain.models.HeaterType
import com.mvptest.presentation.ui.common.CalculatingButton
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Preview
@Composable
fun NewRoomScreenThird(
//    newRoomViewModel: NewRoomViewModel,
//    newProjectViewModel: NewProjectViewModel,
//    onBackPressed: () -> Unit,
//    onSaveRoomClicked: () -> Unit
) {

    val heaterTypes = listOf(HeaterType.NONE, HeaterType.WATER, HeaterType.ELECTRICITY)
    val heaterNames = listOf(
        stringResource(id = R.string.no_heater),
        stringResource(id = R.string.water_heater),
        stringResource(id = R.string.electro_heater)
    )

    var airExchangePerformance by remember {
        mutableStateOf(value = "")
    }

    var pressureLoss by remember {
        mutableStateOf(value = "")
    }

    var airDuctArea by remember {
        mutableStateOf(value = "")
    }

    var heaterType by remember {
        mutableStateOf(value = "")
    }

    var heaterPerformance by remember {
        mutableStateOf(value = "")
    }

    var isAirConditioner by remember {
        mutableStateOf(value = "")
    }

    var airConditionerPerformance by remember {
        mutableStateOf(value = "")
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
                    text = "newRoomViewModel.state.title ?:",
                    fontSize = 22.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = "newProjectViewModel.state.address ?: ",
                    fontSize = 16.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

        }

        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(id = R.string.air_exchange_performance)
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = airExchangePerformance,
                onValueChange = {
//                newRoomViewModel.setSystemNumber(it)
                    airExchangePerformance = it
                },
                hint = stringResource(id = R.string.value_m3),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 25.dp)
            ) {}
        }

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = stringResource(id = R.string.pressure_loss_and_air_area)
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = airExchangePerformance,
            onValueChange = {
//                newRoomViewModel.setSystemNumber(it)
                airExchangePerformance = it
            },
            hint = stringResource(id = R.string.pressure_loss),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = airExchangePerformance,
            onValueChange = {
//                newRoomViewModel.setSystemNumber(it)
                airExchangePerformance = it
            },
            hint = stringResource(id = R.string.air_duct_area),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        CalculatingButton(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 25.dp, top = 10.dp)
        ) {}


        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = stringResource(id = R.string.heater_type)
        )
        Box(
            modifier = Modifier
                .padding(top = 5.dp)
                .background(
                    colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Row(modifier = Modifier.padding(horizontal = 25.dp)) {
                for (index in 0..2) {
                    Button(
                        onClick = {
                            heaterType = heaterTypes[index].name
                            selectedHeaterButtonIndex = index
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)
                            .background(
                                color = colorResource(id = R.color.light_gray),
                                shape = RoundedCornerShape(100.dp)
                            )
                            .border(BorderStroke(1.dp, color = colorResource(id = R.color.gray))),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (selectedHeaterButtonIndex == index) colorResource(
                                id = R.color.dark_gray_2
                            ) else colorResource(id = R.color.light_gray),
                            contentColor = if (selectedHeaterButtonIndex == index) Color.White else colorResource(
                                id = R.color.gray
                            )
                        )
                    ) {
                        Text(
                            modifier = Modifier.fillMaxSize(),
                            text = heaterNames[index],
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }


        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = stringResource(id = R.string.heater_performance)
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = airExchangePerformance,
                onValueChange = {
//                newRoomViewModel.setSystemNumber(it)
                    airExchangePerformance = it
                },
                hint = stringResource(id = R.string.value_kvt),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 25.dp)
            ) {}
        }

    }

}
