package com.mvptest.presentation.ui.common

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun MyAlertDialog(
    titleId: Int,
    confirmButtonText: Int,
    onCancelClicked: () -> Unit,
    onConfirmClicked: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier,
        title = {
            Text(
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = titleId),
            )
        },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        onDismissRequest = { onCancelClicked() },
        buttons = {
            Row(
                modifier = Modifier.padding(
                    top = 15.dp,
                    start = 25.dp,
                    end = 25.dp,
                    bottom = 20.dp,
                ),
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2)),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { onCancelClicked() },
                    content = {
                        Text(
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            text = stringResource(id = R.string.cancel),
                            color = Color.White,
                        )
                    },
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.light_gray)),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { onConfirmClicked() },
                    content = {
                        Text(
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            text = stringResource(id = confirmButtonText),
                            color = colorResource(id = R.color.dark_gray),
                        )
                    },
                )
            }
        },
    )
}

@Composable
fun MyAlertDialogOneAnswer(
    titleId: Int,
    confirmButtonText: Int,
    error: String,
    onCancelClicked: () -> Unit,
    onConfirmClicked: () -> Unit,
    onEmailChanged: (text: String) -> Unit,
) {
    var textField by remember { mutableStateOf(value = "") }
    AlertDialog(
        modifier = Modifier,
        title = {
            Text(
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = titleId),
            )
        },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        onDismissRequest = { onCancelClicked() },
        buttons = {
            Column() {
                RoundedTextField(
                    modifier = Modifier
                        .padding(
                            top = 25.dp,
                            start = 25.dp,
                            end = 25.dp,
                        )
                        .fillMaxWidth(),
                    value = textField,
                    onValueChange = { text ->
                        onEmailChanged.invoke(text)
                        textField = text
                    },
                    hint = stringResource(
                        id = R.string.email,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )

                Log.d("dialogerror", "error = $error")
                if (error.isNotEmpty()) {
                    Log.d("dialogerror", "error.isNotEmpty()")

                    Text(
                        modifier = Modifier.padding(top = 10.dp, start = 25.dp, end = 25.dp),
                        text = error,
                        fontFamily = interFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        color = colorResource(id = R.color.red),
                    )
                }

                Button(
                    modifier = Modifier.padding(
                        top = 25.dp,
                        start = 25.dp,
                        end = 25.dp,
                        bottom = 20.dp,
                    ).fillMaxWidth(),
                    enabled = textField.isNotEmpty(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (textField.isNotEmpty()) {
                            colorResource(
                                id = R.color.dark_gray_2,
                            )
                        } else {
                            colorResource(id = R.color.light_gray)
                        },
                    ),
                    shape = RoundedCornerShape(12.dp),
                    onClick = { onConfirmClicked() },
                    content = {
                        Text(
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            text = stringResource(id = confirmButtonText),
                            color = Color.White,
                        )
                    },
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit,
) {
    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            //        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
//            return true
//        }
            override fun isSelectableYear(year: Int) = true
        },
    )

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                modifier = Modifier.padding(end = 15.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)),
                onClick = {
                    onDateSelected(selectedDate)
                    onDismiss()
                },

            ) {
                Text(text = stringResource(id = R.string.ok), color = Color.White)
            }
        },
        dismissButton = {
            Button(
                modifier = Modifier.padding(end = 5.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)),
                onClick = {
                    onDismiss()
                },
            ) {
                Text(text = stringResource(id = R.string.cancel), color = Color.White)
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = colorResource(id = R.color.light_gray),
        ),
    ) {
        DatePicker(
            state = datePickerState,
        )
    }
}

@Composable
fun RegisterOfferDialog(onConfirmClicked: () -> Unit, onCancelClicked: () -> Unit) {
    AlertDialog(
        modifier = Modifier,
        title = {
            Text(
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.register_offer),
            )
        },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
        onDismissRequest = { onCancelClicked() },
        buttons = {
            Column {
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(16.dp),
                    content = {
                        Row(modifier = Modifier) {
                            Text(
                                text = stringResource(id = R.string.register_or_login),
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 10.dp),
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center,
                                fontFamily = interFamily,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    },
                    onClick = { onConfirmClicked() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(
                            R.color.dark_gray_2,
                        ),
                    ),
                )
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 25.dp),
                    shape = RoundedCornerShape(16.dp),
                    content = {
                        Row(modifier = Modifier) {
                            Text(
                                text = stringResource(id = R.string.not_now),
                                modifier = Modifier
                                    .padding(top = 10.dp, bottom = 10.dp),
                                color = colorResource(id = R.color.dark_gray),
                                textAlign = TextAlign.Center,
                                fontFamily = interFamily,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    },
                    onClick = { onCancelClicked() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(
                            R.color.light_gray,
                        ),
                    ),
                )
            }
        },
    )
}

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy")
    return formatter.format(Date(millis))
}
