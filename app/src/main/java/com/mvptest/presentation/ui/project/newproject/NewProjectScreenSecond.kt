package com.mvptest.presentation.ui.project.newproject

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.MyDatePickerDialog
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun NewProjectScreenSecond(
    viewModel: NewProjectViewModel,
    onBackPressed: () -> Unit,
    onContinueButtonClick: (id: String) -> Unit,
    context: Context,
) {
    var address by remember {
        mutableStateOf(value = viewModel.state.address ?: "")
    }
    var startDate by remember {
        mutableStateOf(value = viewModel.state.startDate ?: "")
    }
    val isCalendarClicked = remember { mutableStateOf(false) }
    var contact by remember {
        mutableStateOf(value = viewModel.state.contact ?: "")
    }
    var contactPhone by remember {
        mutableStateOf(value = viewModel.state.contactPhone ?: "")
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.dark_blue),
                        shape = RoundedCornerShape(25.dp),
                    ),
            ) {
                Text(
                    modifier = Modifier.padding(start = 25.dp, bottom = 16.dp, top = 16.dp),
                    text = viewModel.state.title ?: "",
                    fontSize = 22.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = address,
                onValueChange = {
                    viewModel.setAddress(it)
                    address = it
                },
                hint = stringResource(id = R.string.project_address),
            )

            Box(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clickable {
                        isCalendarClicked.value = true
                    },
            ) {
                RoundedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = startDate,
                    onValueChange = {
                        viewModel.setStartDate(it)
                        startDate = it
                    },
                    hint = stringResource(id = R.string.start_date),
                    enabled = false,
                )
                Icon(
                    modifier = Modifier
                        .padding(end = 25.dp)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.ic_calculator),
                    contentDescription = "image",
                    tint = colorResource(
                        id = R.color.gray,
                    ),
                )
            }

            if (isCalendarClicked.value) {
                MyDatePickerDialog(onDateSelected = { date ->
                    startDate = date
                    viewModel.setStartDate(date)
                }) { isCalendarClicked.value = false }
            }

            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = contact,
                onValueChange = {
                    viewModel.setContact(it)
                    contact = it
                },
                hint = stringResource(id = R.string.contact),
            )

            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = contactPhone,
                onValueChange = {
                    viewModel.setContactPhone(it)
                    contactPhone = it
                },
                hint = stringResource(id = R.string.contact_phone),
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
                    },
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
                                    .height(11.dp)
                                    .width(14.dp),
                                painter = painterResource(id = R.drawable.ic_check),
                                contentDescription = "image",
                                tint = Color.White,
                            )
                            Text(
                                text = stringResource(id = R.string.save_button),
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
                        viewModel.saveProject()
                        onContinueButtonClick.invoke(viewModel.projectId)
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2)),
                )
            }
            if (viewModel.state.somethingWrong == true) {
                Toast.makeText(
                    context,
                    "Что то пошло не так, попробуйте еще раз",
                    Toast.LENGTH_SHORT,
                )
                    .show()
                viewModel.clearAllError()
            }
        }
        if (viewModel.state.isLoading == true) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(60.dp),
                    color = colorResource(id = R.color.dark_blue),
                )
            }
        }
    }
}
