package com.mvptest.presentation.ui.calculation.calculators.aerodynamic

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.calculation.CalculationResult
import com.mvptest.presentation.ui.calculation.calculators.airheater.AirHeaterHelper
import com.mvptest.domain.models.CalculationType
import com.mvptest.presentation.ui.calculation.calculators.airexchange.AirExchangeHelper
import com.mvptest.presentation.ui.common.ButtonIconAndText
import com.mvptest.presentation.ui.common.CalculatorsResult
import com.mvptest.presentation.ui.common.TextMediumBlack14sp
import com.mvptest.presentation.ui.common.TextTitle
import com.mvptest.presentation.ui.room.newroom.NewRoomViewModel
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun AerodynamicScreen(
    isFromProject: String,
    aerodynamicViewModel: AerodynamicViewModel,
    onBackPressed: () -> Unit,
    onBackPressedFromProject: () -> Unit,
    newRoomViewModel: NewRoomViewModel
) {

    val activity = LocalContext.current as AppCompatActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    var isResult by remember {
        mutableStateOf(value = false)
    }

    var aerodynamicResult by remember {
        mutableStateOf(value = CalculationResult(CalculationType.AIR_HEATER, ""))
    }

    var isSomethingWrong by remember {
        mutableStateOf(value = false)
    }

    var sectionNumber = 1

    val sections by remember {
        derivedStateOf { aerodynamicViewModel.state.sections }
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
                    text = stringResource(id = R.string.aerodynamic_title),
                    colorId = R.color.white
                )
            }

            if(isPortrait) {
                Row(modifier = Modifier.padding(top = 25.dp)) {

                    TextMediumBlack14sp(
                        modifier = Modifier,
                        text = stringResource(id = R.string.advice_turn_devise)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier.background(
                            color = colorResource(id = R.color.dark_gray_2),
                            shape = RoundedCornerShape(16.dp)
                        )
                    ) {
                        Icon(
                            modifier = Modifier.padding(10.dp),
                            painter = painterResource(id = R.drawable.ic_turn_device),
                            contentDescription = "image",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                }
            }


            Row(
                modifier = Modifier
                    .padding(top = 34.dp)
                    .fillMaxWidth()
            ) {
                TextMediumBlack14sp(
                    modifier = Modifier.weight(0.05f),
                    text = stringResource(id = R.string.aerodynamic_number),
                    centerText = true
                )
                TextMediumBlack14sp(
                    modifier = Modifier.weight(0.2f),
                    text = stringResource(id = R.string.aerodynamic_air_flow),
                    centerText = true
                )
                TextMediumBlack14sp(
                    modifier = Modifier.weight(0.15f),
                    text = stringResource(id = R.string.aerodynamic_length),
                    centerText = true
                )
                TextMediumBlack14sp(
                    modifier = Modifier.weight(0.25f),
                    text = stringResource(id = R.string.aerodynamic_cut_area),
                    centerText = true
                )
                TextMediumBlack14sp(
                    modifier = Modifier.weight(0.35f),
                    text = stringResource(id = R.string.aerodynamic_elements),
                    centerText = true
                )
            }
        }

        items(sections) { item ->
            SectionItem(item, aerodynamicViewModel, onRemoveSection = {
                aerodynamicViewModel.deleteSection(it)
                sectionNumber--
            })
        }

        item {

            ButtonIconAndText(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                iconId = R.drawable.ic_add,
                textId = R.string.add_section,
                onClick = {
                    aerodynamicViewModel.newSection(sectionNumber)
                    sectionNumber++
                }
            )

            if (isResult && !isSomethingWrong) {
                CalculatorsResult(
                    calculationResult = aerodynamicResult
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
                    onClick = { if(isFromProject == "true") onBackPressedFromProject() else onBackPressed() },
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
                        if (isResult && isFromProject == "true") {
                            onBackPressedFromProject()
                        } else {
                            val result = aerodynamicViewModel.calculate()

                            if (result != null) {
                                aerodynamicResult = result
                                isResult = true
                                if (isFromProject == "true") {
                                    newRoomViewModel.setPressureLoss(result.firstResult)
                                }
                            } else {
                                isSomethingWrong = true
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
                )
            }
        }
    }

    BackHandler {
        if (isFromProject == "true") onBackPressedFromProject() else onBackPressed()
    }

}