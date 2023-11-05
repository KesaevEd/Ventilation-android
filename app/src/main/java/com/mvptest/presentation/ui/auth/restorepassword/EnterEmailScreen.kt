package com.mvptest.presentation.ui.auth.restorepassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.auth.UserAuthViewModel
import com.mvptest.presentation.ui.common.BigTextTitle
import com.mvptest.presentation.ui.common.ButtonWithText
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.ventilation.R

@Composable
fun EnterEmailScreen(
    userAuthViewModel: UserAuthViewModel,
    navController: NavController
) {
    var email by remember { mutableStateOf(value = "") }

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
                    id = R.string.restore_password
                )
            )
            RoundedTextField(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                value = email,
                onValueChange = { text ->
                    email = text
                    userAuthViewModel.setEmail(text)
                },
                hint = stringResource(
                    id = R.string.email
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            ButtonWithText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                textId = R.string.send_code,
                onClick = {
                    userAuthViewModel.sendCodeToEmailChangePassword()
                }
            )

            if (userAuthViewModel.state.isSuccessSendCode == true) {
                navController.navigate(NavigationAuthItem.EmailCode.route.replace(
                    oldValue = "{fromForgotPassword}",
                    newValue = "true"
                ))
                userAuthViewModel.stopSuccessSendCode()
            }

            if (userAuthViewModel.state.isEmailNotFound == true) {
                userAuthViewModel.clearAllError()
            }

            if (userAuthViewModel.state.somethingWrong == true) {
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