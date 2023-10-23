package com.mvptest.presentation.ui.auth

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import kotlin.math.log

sealed class NavigationAuthItem(val route: String) {
    object Login : NavigationAuthItem(route = "login")
    object Registration : NavigationAuthItem(route = "registration")
    object EmailCode : NavigationAuthItem(route = "email_code")
    object ForgotPassword : NavigationAuthItem(route = "forgot_password")
}

fun NavGraphBuilder.authGraph(
    navController: NavController,
    userAuthViewModel: UserAuthViewModel,
    context: Context
) {
    navigation(startDestination = NavigationAuthItem.Registration.route, route = "auth") {
        composable(route = NavigationAuthItem.Registration.route) {
            RegistrationScreen(logUpClick = {
                navController.navigate(NavigationAuthItem.EmailCode.route)
            }, userAuthViewModel, context)
        }
        composable(route = NavigationAuthItem.EmailCode.route) {
            EmailCodeScreen(userAuthViewModel, context, logUpClick =  {
                navController.navigate(NavigationItem.Home.route)
            })
        }
        composable(route = NavigationAuthItem.ForgotPassword.route) {
            ForgotPasswordScreen()
        }
    }
}