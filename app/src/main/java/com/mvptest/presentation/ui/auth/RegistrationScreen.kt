package com.mvptest.presentation.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.PasswordTextField
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R


@Composable
fun RegistrationScreen(logUpClick: () -> Unit) {
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordRepeatVisible by remember { mutableStateOf(false) }
    var checkBoxChecked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp, top = 35.dp)
    ) {
        BigTextTitle(
            modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                id = R.string.registration
            )
        )
        RoundedTextField(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = { text -> email = text },
            hint = stringResource(
                id = R.string.email
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Box(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = {
//                    viewModel.setStartDate(it)
                    password = it
                },
                hint = stringResource(id = R.string.password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
            Icon(
                modifier = Modifier
                    .padding(end = 25.dp)
                    .align(Alignment.CenterEnd)
                    .clickable { passwordVisible = !passwordVisible },
                painter = if (passwordVisible) painterResource(id = R.drawable.ic_unvisible) else painterResource(
                    id = R.drawable.ic_visible
                ),
                contentDescription = "image",
                tint = colorResource(
                    id = R.color.gray
                )
            )
        }

        Box(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordRepeat,
                onValueChange = {
//                    viewModel.setStartDate(it)
                    passwordRepeat = it
                },
                hint = stringResource(id = R.string.password),
                visualTransformation = if (passwordRepeatVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
            Icon(
                modifier = Modifier
                    .padding(end = 25.dp)
                    .align(Alignment.CenterEnd)
                    .clickable { passwordRepeatVisible = !passwordRepeatVisible },
                painter = if (passwordRepeatVisible) painterResource(id = R.drawable.ic_unvisible) else painterResource(
                    id = R.drawable.ic_visible
                ),
                contentDescription = "image",
                tint = colorResource(
                    id = R.color.gray
                )
            )
        }

        Row(modifier = Modifier.padding(top = 26.dp)) {
            Checkbox(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
                    .padding(top = 8.dp),
                checked = checkBoxChecked,
                onCheckedChange = { checkBoxChecked = !checkBoxChecked },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(id = R.color.gray),
                    uncheckedColor = colorResource(id = R.color.gray),
                    checkmarkColor = colorResource(id = R.color.dark_gray_2)
                )
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = stringResource(id = R.string.agreement),
                fontFamily = interFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.dark_gray_2)
            )
        }

        ButtonWithText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            textId = R.string.sign_up,
            onClick = { logUpClick() }
        )
    }
}