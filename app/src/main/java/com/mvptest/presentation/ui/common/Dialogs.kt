package com.mvptest.presentation.ui.common

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mvptest.ventilation.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

//fun DatePickerDialog(
//    context: Context,
//    selectedDate: MutableState<Date>,
//    onDateSelected: (Date) -> Unit
//) {
//    val calendar = Calendar.getInstance()
//    calendar.time = selectedDate.value
//
//    val onDateSet: DatePickerDialog.OnDateSetListener =
//        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
//            calendar.set(Calendar.YEAR, year)
//            calendar.set(Calendar.MONTH, month)
//            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//            selectedDate.value = calendar.time
//            onDateSelected(calendar.time)
//        }
//
//    val onClick: () -> Unit = {
//        val datePickerDialog = DatePickerDialog(
//            context,
//            onDateSet,
//            calendar.get(Calendar.YEAR),
//            calendar.get(Calendar.MONTH),
//            calendar.get(Calendar.DAY_OF_MONTH)
//        )
//        datePickerDialog.show()
//    }
//
//    Button(onClick = onClick) {
//        Text(text = "Select Date")
//    }
//}


@RequiresApi(Build.VERSION_CODES.N)
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
            Button(modifier = Modifier.padding(end = 15.dp), shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)), onClick = {
                onDateSelected(selectedDate)
                onDismiss()
            }

            ) {
                Text(text = stringResource(id = R.string.ok), color = Color.White)
            }
        },
        dismissButton = {
            Button(modifier = Modifier.padding(end = 5.dp), shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)), onClick = {
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