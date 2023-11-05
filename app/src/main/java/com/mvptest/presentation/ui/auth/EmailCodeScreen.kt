package com.mvptest.presentation.ui.auth

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R
import kotlinx.coroutines.delay

@Composable
fun EmailCodeScreen(
    userAuthViewModel: UserAuthViewModel,
    context: Context,
    navController: NavController,
    fromForgotPassword: String
) {
    var emailCode by remember { mutableStateOf("") }
    var sendRepeatTextColor by remember { mutableIntStateOf(R.color.gray) }
    var registerButtonColor by remember { mutableIntStateOf(R.color.gray) }
    var canRegister by remember { mutableStateOf(false) }

    var timeLeft by remember { mutableIntStateOf(60) }

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft == 0) {
            sendRepeatTextColor = R.color.dark_gray_2
        }
        while (timeLeft > 0) {
            sendRepeatTextColor = R.color.gray
            delay(1000L)
            timeLeft--
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(start = 18.dp, end = 18.dp, top = 150.dp)
        ) {
            BigTextTitle(
                modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                    id = if(fromForgotPassword == "false") R.string.registration else R.string.restore_password
                )
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 21.dp)
                    .fillMaxWidth(),
                value = emailCode,
                onValueChange = { text ->
                    if (text.length <= 5) {
                        emailCode = text
                        if (text.length == 5) {
                            canRegister = true
                            registerButtonColor = R.color.dark_gray_2
                        }
                    }
                },
                hint = stringResource(
                    id = R.string.send_code_to_email
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            if (userAuthViewModel.state.isCodeIncorrect == true) {
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(id = R.string.password_not_same),
                    fontFamily = interFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = colorResource(id = R.color.red)
                )
            }

            ButtonWithText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                textId = if(fromForgotPassword == "true") R.string.do_restore_password else R.string.sign_up,
                buttonColor = registerButtonColor,
                onClick = {
                    if (canRegister) {
                        userAuthViewModel.checkEmailCode(emailCode, fromForgotPassword, navController)
                    }
                }
            )

            Text(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        if (timeLeft == 0) {
                            timeLeft = 60
                            userAuthViewModel.sendCodeToEmail()
                        }
                    },
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
                text = "$timeLeft" + " " + stringResource(id = R.string.seconds),
                fontFamily = interFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = colorResource(id = R.color.gray)
            )

        }

        if (userAuthViewModel.state.isSuccessRegistration == true) {
            userAuthViewModel.stopSuccessRegister()
            if (fromForgotPassword == "false") {
                navController.navigate(NavigationItem.Home.route)
                Toast.makeText(context, "Регистрация прошла успешно", Toast.LENGTH_SHORT)
                    .show()
            } else {
                navController.navigate(NavigationAuthItem.RestorePassword.route)
            }
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

        if (userAuthViewModel.state.isLoading == true) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
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