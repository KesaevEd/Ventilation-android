package com.mvptest.presentation.ui.room.newroom

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.VentSystemDestination
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.calculation.NavigationCalculationItem
import com.mvptest.presentation.ui.common.BackOrSaveRow
import com.mvptest.presentation.ui.common.CalculatingButton
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.presentation.ui.project.newproject.NewProjectViewModel
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun NewRoomScreenThird(
    newRoomViewModel: NewRoomViewModel,
    newProjectViewModel: NewProjectViewModel,
    onBackPressed: () -> Unit,
    onSaveRoomClicked: (projectId: String) -> Unit,
    navController: NavController,
) {
    val activity = LocalContext.current as AppCompatActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val heaterTypes = listOf(HeaterType.NONE, HeaterType.WATER, HeaterType.ELECTRICITY)
    val heaterNames = listOf(
        stringResource(id = R.string.no_heater),
        stringResource(id = R.string.water_heater),
        stringResource(id = R.string.electro_heater),
    )

    var airExchangePerformance by remember {
        mutableStateOf(value = newRoomViewModel.state.airExchangePerformance ?: "")
    }

    var pressureLoss by remember {
        mutableStateOf(value = newRoomViewModel.state.pressureLoss ?: "")
    }

    var airDuctCrossSize by remember {
        mutableStateOf(value = newRoomViewModel.state.airDuctArea ?: "")
    }

    var heaterType by remember {
        mutableStateOf(value = newRoomViewModel.state.heaterType ?: HeaterType.NONE)
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

    var selectedHeaterButtonIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.dark_blue),
                    shape = RoundedCornerShape(25.dp),
                ),
        ) {
            Column(modifier = Modifier.padding(start = 25.dp, bottom = 25.dp, top = 25.dp)) {
                Text(
                    modifier = Modifier.padding(),
                    text = newRoomViewModel.state.title ?: "",
                    fontSize = 22.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = newProjectViewModel.state.address ?: "",
                    fontSize = 16.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                )
            }
        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 20.dp),
            textId = R.string.air_exchange_performance,
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = airExchangePerformance,
                onValueChange = {
                    newRoomViewModel.setAirExchangePerformance(it)
                    airExchangePerformance = it
                },
                hint = stringResource(id = R.string.value_m3),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
            ) {
                navigateToCalculatorScreen(
                    NavigationCalculationItem.AirExchange.route,
                    navController,
                )
            }
        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.air_duct_cross,
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = airDuctCrossSize,
                onValueChange = {
                    newRoomViewModel.setAirDuctCross(it)
                    airDuctCrossSize = it
                },
                hint = stringResource(id = R.string.value),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
            ) {
                navigateToCalculatorScreen(
                    NavigationCalculationItem.DuctCrossSection.route,
                    navController,
                )
            }
        }

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.pressure_loss,
        )
        Box(modifier = Modifier.padding(top = 5.dp)) {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = pressureLoss,
                onValueChange = {
                    newRoomViewModel.setPressureLoss(it)
                    pressureLoss = it
                },
                hint = stringResource(id = R.string.value_pa),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            CalculatingButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 15.dp),
            ) {
                navigateToCalculatorScreen(
                    NavigationCalculationItem.Aerodynamic.route,
                    navController,
                )
            }
        }

        if (newRoomViewModel.state.ventSystemDestination == VentSystemDestination.FORCED || newRoomViewModel.state.ventSystemDestination == VentSystemDestination.FORCED_EXHAUST) {
            TextTitleOfTextField(
                modifier = Modifier.padding(top = 15.dp),
                textId = R.string.heater_type,
            )
            Box(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .background(
                        colorResource(id = R.color.light_gray),
                        shape = RoundedCornerShape(15.dp),
                    ),
            ) {
                Row() {
                    selectedHeaterButtonIndex = heaterTypes.indexOf(heaterType)
                    for (index in 0..2) {
                        Button(
                            onClick = {
                                heaterType = heaterTypes[index]
                                newRoomViewModel.setHeaterType(heaterTypes[index])
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp),
                            border = BorderStroke(
                                1.dp,
                                color = colorResource(id = R.color.gray),
                            ),
                            shape = RoundedCornerShape(100.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (selectedHeaterButtonIndex == index) {
                                    colorResource(
                                        id = R.color.dark_gray_2,
                                    )
                                } else {
                                    colorResource(id = R.color.light_gray)
                                },
                                contentColor = if (selectedHeaterButtonIndex == index) {
                                    Color.White
                                } else {
                                    colorResource(
                                        id = R.color.gray,
                                    )
                                },
                            ),
                            content = {
                                Text(
                                    modifier = Modifier.fillMaxHeight(),
                                    text = heaterNames[index],
                                    fontFamily = interFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                )
                            },
                        )
                    }
                }
            }

            if (heaterType != HeaterType.NONE) {
                TextTitleOfTextField(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.heater_performance,
                )
                Box(modifier = Modifier.padding(top = 5.dp)) {
                    RoundedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = heaterPerformance,
                        onValueChange = {
                            newRoomViewModel.setHeaterPerformance(it)
                            heaterPerformance = it
                        },
                        hint = stringResource(id = R.string.value_kvt),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    CalculatingButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 15.dp),
                    ) {
                        navigateToCalculatorScreen(
                            NavigationCalculationItem.AirHeater.route,
                            navController,
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .background(
                        colorResource(id = R.color.light_gray),
                        shape = RoundedCornerShape(15.dp),
                    ),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.air_conditioner),
                        modifier = Modifier.padding(start = 25.dp, top = 21.dp, bottom = 21.dp),
                    )
                    Spacer(Modifier.weight(1f))
                    RadioButton(
                        modifier = Modifier.padding(end = 15.dp),
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = colorResource(id = R.color.dark_gray),
                            selectedColor = colorResource(
                                id = R.color.dark_gray,
                            ),
                        ),
                        selected = isAirConditioner,
                        onClick = {
                            isAirConditioner = !isAirConditioner
                            newRoomViewModel.setIsAirConditioner(isAirConditioner)
                        },
                    )
                }
            }

            if (isAirConditioner) {
                TextTitleOfTextField(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.air_conditioner_performance,
                )
                Box(modifier = Modifier.padding(top = 5.dp)) {
                    RoundedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = airConditionerPerformance,
                        onValueChange = {
                            newRoomViewModel.setAirConditionerPerformance(it)
                            airConditionerPerformance = it
                        },
                        hint = stringResource(id = R.string.value_kvt),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    CalculatingButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 15.dp),
                    ) {
                        navigateToCalculatorScreen(
                            NavigationCalculationItem.Conditioner.route,
                            navController,
                        )
                    }
                }
            }
        }

        BackOrSaveRow(onBackPressed = { onBackPressed() }, onSaveClick = {
            newRoomViewModel.saveRoom(projectId = newProjectViewModel.projectId)
            newRoomViewModel.clearState()
            onSaveRoomClicked(newProjectViewModel.projectId)
        })
    }
}

private fun navigateToCalculatorScreen(route: String, navController: NavController) {
    navController.navigate(
        route.replace(
            oldValue = "{fromProject}",
            newValue = "true",
        ),
    ) {
        popUpTo(
            NavigationItem.Calculating.route,
        ) {
            inclusive = true
        }
    }
}
