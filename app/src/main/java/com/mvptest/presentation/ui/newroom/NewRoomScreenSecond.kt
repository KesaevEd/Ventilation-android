package com.mvptest.presentation.ui.newroom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.mvptest.presentation.ui.common.MyDatePickerDialog
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.presentation.ui.newproject.NewProjectViewModel
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun NewRoomScreenSecond(
    newRoomViewModel: NewRoomViewModel,
    newProjectViewModel: NewProjectViewModel,
    onBackPressed: () -> Unit,
    onContinueButtonClick: () -> Unit
) {

    var systemNumber by remember {
        mutableStateOf(value = newRoomViewModel.state.systemNumber ?: "")
    }
    var roomVolume by remember {
        mutableStateOf(value = newRoomViewModel.state.roomVolume ?: "")
    }
    var roomDestination by remember {
        mutableStateOf(value = newRoomViewModel.state.roomDestination ?: "")
    }
    var startDate by remember {
        mutableStateOf(value = newRoomViewModel.state.startDate ?: "")
    }
    val isCalendarClicked = remember { mutableStateOf(false) }
    var deadLines by remember {
        mutableStateOf(value = newRoomViewModel.state.deadLines ?: "")
    }
    var comment by remember {
        mutableStateOf(value = newRoomViewModel.state.comment ?: "")
    }


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
            textId = R.string.vent_system_number
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = systemNumber,
            onValueChange = {
                newRoomViewModel.setSystemNumber(it)
                systemNumber = it
            },
            hint = stringResource(id = R.string.vent_system_number)
        )

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.room_volume
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = roomVolume.toString(),
            onValueChange = {
                newRoomViewModel.setRoomVolume(it.toInt())
                roomVolume = it
            },
            hint = stringResource(id = R.string.room_volume),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.room_destination
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = roomDestination,
            onValueChange = {
                newRoomViewModel.setRoomDestination(it)
                roomDestination = it
            },
            hint = stringResource(id = R.string.room_destination)
        )

        TextTitleOfTextField(modifier = Modifier.padding(top = 15.dp), textId = R.string.start_date)
        Box() {
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                value = startDate,
                onValueChange = {
                    newRoomViewModel.setStartDate(it)
                    startDate = it
                },
                hint = stringResource(id = R.string.start_date)
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 25.dp)
                    .clickable {
                        isCalendarClicked.value = true
                    },
                painter = painterResource(id = R.drawable.ic_calculator),
                contentDescription = "image",
                tint = colorResource(
                    id = R.color.gray
                )
            )
        }

        if (isCalendarClicked.value) {
            MyDatePickerDialog(onDateSelected = { date ->
                startDate = date
                newRoomViewModel.setStartDate(date)
            }) { isCalendarClicked.value = false }
        }

        TextTitleOfTextField(modifier = Modifier.padding(top = 15.dp), textId = R.string.dead_lines)
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = deadLines,
            onValueChange = {
                newRoomViewModel.setDeadLines(it)
                deadLines = it
            },
            hint = stringResource(id = R.string.dead_lines)
        )

        TextTitleOfTextField(
            modifier = Modifier.padding(top = 15.dp),
            textId = R.string.comment_room
        )
        RoundedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            value = comment,
            onValueChange = {
                newRoomViewModel.setComment(it)
                comment = it
            },
            hint = stringResource(id = R.string.comment_room),
            singleLine = false
        )

        Row(modifier = Modifier.padding(top = 30.dp)) {
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
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = stringResource(id = R.string.forward),
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 15.dp),
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "image",
                            tint = Color.White,
                        )
                    }
                },
                onClick = {
                    onContinueButtonClick()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        }
    }
}