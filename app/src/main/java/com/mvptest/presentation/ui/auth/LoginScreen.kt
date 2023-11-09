package com.mvptest.presentation.ui.auth

import android.content.Context
import android.content.pm.ActivityInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.HorizontalLine
import com.mvptest.presentation.ui.common.PasswordTextField
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun LoginScreen(
    userAuthViewModel: UserAuthViewModel,
    context: Context,
    forgotPasswordClick: () -> Unit,
    logInClick: () -> Unit,
    logUpClick: () -> Unit
) {
    val activity = LocalContext.current as AppCompatActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(start = 18.dp, end = 18.dp, top = 35.dp)
        ) {
            BigTextTitle(
                modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                    id = R.string.enter
                )
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                value = email,
                onValueChange = { text ->
                    userAuthViewModel.clearAllError()
                    userAuthViewModel.setEmail(text)
                    email = text
                },
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
                        userAuthViewModel.clearAllError()
                        userAuthViewModel.setPassword(it)
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

            if (userAuthViewModel.state.isPasswordInvalid == true) {
                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stringResource(id = R.string.password_invalid),
                    fontFamily = interFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.red)
                )
            }

            if (userAuthViewModel.state.isUserNotFound == true) {
                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stringResource(id = R.string.user_not_found),
                    fontFamily = interFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.red)
                )
            }

            ButtonWithText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                textId = R.string.sign_in,
                onClick = {
                    if(email.isNotEmpty() && password.isNotEmpty()) {
                        userAuthViewModel.login()
                    }
                }
            )

            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable { forgotPasswordClick() },
                text = stringResource(id = R.string.forgot_password),
                fontFamily = interFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.dark_gray_2)
            )

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                HorizontalLine(modifier = Modifier.align(Alignment.CenterVertically))
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically),
                    text = stringResource(id = R.string.or),
                    fontFamily = interFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.dark_gray_2)
                )
                HorizontalLine(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            ButtonWithText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                textId = R.string.sign_up,
                onClick = { logUpClick() }
            )

            if (userAuthViewModel.state.isSuccessLogin == true) {
                logInClick()
                userAuthViewModel.stopSuccessLogin()
            }

            if (userAuthViewModel.state.somethingWrong == true) {
                Toast.makeText(
                    context,
                    "Что то пошло не так, попробуйте еще раз",
                    Toast.LENGTH_SHORT
                )
                    .show()
                userAuthViewModel.clearAllError()
            }
        }
        if (userAuthViewModel.state.isLoading == true) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(60.dp),
                    color = colorResource(id = R.color.dark_blue)
                )
            }
        }
    }
}