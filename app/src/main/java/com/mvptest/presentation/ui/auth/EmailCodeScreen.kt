package com.mvptest.presentation.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Preview
@Composable
fun EmailCodeScreen() {
    var emailCode by remember { mutableStateOf("") }
    var sendRepeatTextColor by remember { mutableIntStateOf(R.color.dark_gray_2) }
    var seconds by remember { mutableStateOf("30") }

    Column(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 150.dp)
    ) {
        BigTextTitle(
            modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                id = R.string.registration
            )
        )
        RoundedTextField(
            modifier = Modifier
                .padding(top = 21.dp)
                .fillMaxWidth(),
            value = emailCode,
            onValueChange = { text -> emailCode = text },
            hint = stringResource(
                id = R.string.send_code_to_email
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        ButtonWithText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            textId = R.string.sign_up,
            onClick = { }
        )

        Text(
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { },
            text = stringResource(id = R.string.send_code_again),
            fontFamily = interFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = colorResource(id = sendRepeatTextColor)
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = seconds + " " + stringResource(id = R.string.seconds),
            fontFamily = interFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = colorResource(id = R.color.gray)
        )

    }
}