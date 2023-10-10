package com.mvptest.presentation.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun MyAlertDialog(titleId: Int, confirmButtonText: Int, onCancelClicked: () -> Unit, onConfirmClicked: () -> Unit) {
    AlertDialog(
        modifier = Modifier,
        title = {
            Text(
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = titleId)
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
                    bottom = 20.dp
                )
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
                            color = Color.White
                        )
                    })
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
                            color = colorResource(id = R.color.dark_gray)
                        )
                    })
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        //        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
//            return true
//        }
        override fun isSelectableYear(year: Int) = true
    })

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
                }

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
                }) {
                Text(text = stringResource(id = R.string.cancel), color = Color.White)
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = colorResource(id = R.color.light_gray)
        )
    ) {
        DatePicker(
            state = datePickerState
        )
    }
}

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy")
    return formatter.format(Date(millis))
}