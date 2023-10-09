package com.mvptest.presentation.ui.roomdetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.mvptest.domain.models.HeaterType
import com.mvptest.presentation.ui.common.TextMediumBlack14sp
import com.mvptest.presentation.ui.common.TextTitle
import com.mvptest.presentation.ui.common.TextTitleOfText
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun RoomDetailsScreen(
    roomDetailsViewModel: RoomDetailsViewModel,
    roomId: String,
    onBackPressed: () -> Unit,
    onEditRoomClicked: (roomId: String) -> Unit,
) {

    roomDetailsViewModel.getRoomById(roomId)

    val state by remember {
        mutableStateOf(value = roomDetailsViewModel.state)
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 100.dp)
                .background(
                    color = colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 25.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TextTitle(
                    modifier = Modifier.padding(top = 25.dp),
                    text = state.value.roomDetails?.title ?: "",
                    colorId = R.color.dark_blue
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 20.dp),
                    textId = R.string.vent_system_number
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.systemNumber ?: ""
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.room_volume
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.roomVolume.toString() + ", " + stringResource(id = R.string.m3)
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.room_destination
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.roomDestination ?: ""
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.start_date
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.startDate ?: ""
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.dead_lines
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.deadLines ?: ""
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.comment_room
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.comment ?: ""
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.air_exchange_performance
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.airExchangePerformance.toString() + ", " + stringResource(
                        id = R.string.m3
                    )
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.pressure_loss
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.pressureLoss.toString() + ", " + stringResource(
                        id = R.string.pa
                    )
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.air_duct_area
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.airDuctArea.toString() + ", " + stringResource(
                        id = R.string.m2
                    )
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.heater_type
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.heaterType?.string ?: HeaterType.NONE.string
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.heater_performance
                )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = state.value.roomDetails?.heaterPerformance.toString() + ", " + stringResource(
                        id = R.string.kvt
                    )
                )

                TextTitleOfText(
                    modifier = Modifier.padding(top = 15.dp),
                    textId = R.string.air_conditioner
                )
                val isConditioner: String =
                    if (state.value.roomDetails?.isAirConditioner == true) stringResource(id = R.string.yes) else stringResource(
                        id = R.string.no
                    )
                TextMediumBlack14sp(
                    modifier = Modifier.padding(top = 5.dp),
                    text = isConditioner
                )

                if (state.value.roomDetails?.isAirConditioner == true) {
                    TextTitleOfText(
                        modifier = Modifier.padding(top = 15.dp),
                        textId = R.string.air_conditioner_performance
                    )
                    TextMediumBlack14sp(
                        modifier = Modifier.padding(top = 5.dp, bottom = 25.dp),
                        text = state.value.roomDetails?.airConditionerPerformance.toString() + ", " + stringResource(
                            id = R.string.kvt
                        )
                    )
                } else {
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
        }


        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 18.dp, end = 18.dp, bottom = 10.dp)
        ) {
            Button(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                onClick = { onBackPressed() },
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
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 15.dp),
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "image",
                            tint = Color.White,
                        )
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = stringResource(id = R.string.edit),
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }
                },
                onClick = {
                    onEditRoomClicked.invoke(roomId)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        }
    }
}
