package com.mvptest.presentation.ui.auth.restorepassword

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
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.auth.UserAuthViewModel
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.PasswordTextField
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun RestorePasswordScreen(
    navController: NavController,
    userAuthViewModel: UserAuthViewModel,
    context: Context
) {
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordRepeatVisible by remember { mutableStateOf(false) }
    var canRestorePassword by remember { mutableStateOf(false) }
    var registerButtonColor by remember { mutableIntStateOf(R.color.gray) }

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
                    id = R.string.restore_password
                )
            )

            Box(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                PasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password ?: "",
                    onValueChange = {
                        if (it.length < 6 || passwordRepeat.length < 6) {
                            canRestorePassword = false
                            registerButtonColor = R.color.gray
                        } else {
                            canRestorePassword = true
                            registerButtonColor = R.color.dark_gray_2
                        }
                        userAuthViewModel.clearAllError()
                        password = it
                    },
                    hint = stringResource(id = R.string.password_registration),
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
                        if (it.length < 6 || password.length < 6) {
                            canRestorePassword = false
                            registerButtonColor = R.color.gray
                        } else {
                            canRestorePassword = true
                            registerButtonColor = R.color.dark_gray_2
                        }
                        passwordRepeat = it
                        userAuthViewModel.clearAllError()
                    },
                    hint = stringResource(id = R.string.repeat_password),
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

            if (userAuthViewModel.state.isPasswordNotSame == true) {
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
                textId = R.string.do_restore_password,
                onClick = {
                    if(canRestorePassword) {
                        if (password == passwordRepeat) {
                            userAuthViewModel.changePassword(password)
                        } else {
                            userAuthViewModel.passwordsNotSame()
                        }
                    }
                },
                buttonColor = registerButtonColor
            )

            if (userAuthViewModel.state.isSuccessChangePassword == true) {
                userAuthViewModel.stopSuccessChangePassword()
                navController.navigate(NavigationAuthItem.Login.route)
            }

            if (userAuthViewModel.state.isEmailNotFound == true) {
                Toast.makeText(context, "Проверьте введенный email адрес", Toast.LENGTH_SHORT)
                    .show()
                userAuthViewModel.clearAllError()
            }

            if (userAuthViewModel.state.isEmailAlreadyExist == true) {
                Toast.makeText(context, "Такой email уже существует", Toast.LENGTH_SHORT)
                    .show()
                userAuthViewModel.clearAllError()
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