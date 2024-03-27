package com.mvptest.presentation.ui.calculation.calculators.airductarea

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.TextTitle
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun AirDuctAreaScreen(
    context: Context,
    isFromProject: String,
    airDuctAreaViewModel: AirDuctAreaViewModel,
    onBackPressed: () -> Unit,
    onBackPressedFromProject: () -> Unit,
//    newRoomViewModel: NewRoomViewModel,
) {
    var airDuctAreaResult by remember {
        mutableStateOf(value = airDuctAreaViewModel.state.totalArea)
    }

    var sectionNumber by remember {
        mutableIntStateOf(value = airDuctAreaViewModel.elementNumber)
    }

    val elements by remember {
        derivedStateOf { airDuctAreaViewModel.state.elements }
    }

    var expanded by remember { mutableStateOf(false) }

    if (expanded) {
        Column(
            modifier = Modifier
                .padding(18.dp),
        ) {
            Row(modifier = Modifier.padding(bottom = 15.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier
                        .padding(top = 5.dp, end = 10.dp)
                        .width(20.dp)
                        .height(20.dp)
                        .clickable { expanded = false },
                    painter = painterResource(id = R.drawable.ic_close),
                    tint = colorResource(id = R.color.dark_gray_2),
                    contentDescription = "icon",
                )
            }
            LazyColumn {
                items(airDuctShortItemList) { item ->
                    Column {
                        Row(
                            modifier = Modifier.clickable {
                                expanded = false
                            },
                        ) {
                            Image(
                                modifier = Modifier.height(120.dp)
                                    .width(120.dp),
                                painter = painterResource(id = item.iconId),
                                contentDescription = "icon",
                            )
                            Text(
                                modifier = Modifier.align(Alignment.CenterVertically)
                                    .padding(start = 10.dp),
                                text = stringResource(id = item.title),
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                            )
                        }

                        Divider(
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .padding(18.dp),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.sand),
                            shape = RoundedCornerShape(25.dp),
                        ),
                ) {
                    TextTitle(
                        modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp),
                        text = stringResource(id = R.string.air_duct_area_title),
                        colorId = R.color.white,
                    )
                }
            }

            items(elements) { item ->
                ElementItem(item.toAirDuctElement(), onDeleteClick = {
                }, onIncreaseCountClick = {}, onDecreaseCountClick = {})
            }

            item {
                Row(
                    modifier = Modifier.padding(top = 30.dp, bottom = 15.dp),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Button(
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp),
                        onClick = { if (isFromProject == "true") onBackPressedFromProject() else onBackPressed() },
                        border = BorderStroke(
                            1.dp,
                            color = colorResource(id = R.color.dark_gray_2),
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
                        },
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(16.dp),
                        content = {
                            Row() {
                                Icon(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .height(14.dp)
                                        .width(14.dp),
                                    painter = painterResource(id = R.drawable.ic_add),
                                    contentDescription = "image",
                                    tint = Color.White,
                                )
                                Text(
                                    text = stringResource(id = R.string.add_element),
                                    modifier = Modifier
                                        .padding(start = 15.dp),
                                    color = colorResource(id = R.color.white),
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    fontFamily = interFamily,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        },
                        onClick = {
                            expanded = true
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2)),
                    )
                }
            }
        }
    }

    BackHandler {
        if (!expanded) {
            if (isFromProject == "true") onBackPressedFromProject() else onBackPressed()
        } else {
            expanded = false
        }
    }
}
