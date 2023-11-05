package com.mvptest.presentation.ui.auth

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.auth.restorepassword.EnterEmailScreen
import com.mvptest.presentation.ui.auth.restorepassword.RestorePasswordScreen
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import kotlin.math.log

sealed class NavigationAuthItem(val route: String) {
    object Login : NavigationAuthItem(route = "login")
    object Registration : NavigationAuthItem(route = "registration")
    object EmailCode : NavigationAuthItem(route = "email_code/{fromForgotPassword}")
    object EnterEmail : NavigationAuthItem(route = "enter_email")
    object RestorePassword : NavigationAuthItem(route = "restore_password")
}

fun NavGraphBuilder.authGraph(
    navController: NavController,
    userAuthViewModel: UserAuthViewModel,
    context: Context
) {
    navigation(startDestination = NavigationAuthItem.Registration.route, route = "auth") {
        composable(route = NavigationAuthItem.Registration.route) {
            RegistrationScreen(logUpClick = {
                navController.navigate(NavigationAuthItem.EmailCode.route.replace(
                    oldValue = "{fromForgotPassword}",
                    newValue = "false"
                ))
            }, userAuthViewModel, context)
        }
        composable(route = NavigationAuthItem.EmailCode.route) {
            val fromForgotPassword = it.arguments?.getString("fromForgotPassword")
            EmailCodeScreen(userAuthViewModel, context, navController, fromForgotPassword ?: "false")
        }
        composable(route = NavigationAuthItem.EnterEmail.route) {
            EnterEmailScreen(userAuthViewModel = userAuthViewModel, navController = navController)
        }
        composable(route = NavigationAuthItem.RestorePassword.route) {
            RestorePasswordScreen(userAuthViewModel = userAuthViewModel, navController = navController,
                context = context
            )
        }
    }
}