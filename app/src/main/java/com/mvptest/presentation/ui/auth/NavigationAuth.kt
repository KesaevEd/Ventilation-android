package com.mvptest.presentation.ui.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

sealed class NavigationAuthItem(val route: String) {
    object Login : NavigationAuthItem(route = "login")
    object Registration : NavigationAuthItem(route = "registration")
    object EmailCode : NavigationAuthItem(route = "email_code")
    object ForgotPassword : NavigationAuthItem(route = "forgot_password")
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = NavigationAuthItem.Login.route, route = "login") {
        composable(route = NavigationAuthItem.Login.route) {

        }
        composable(route = NavigationAuthItem.Registration.route) {

        }
        composable(route = NavigationAuthItem.EmailCode.route) {

        }
        composable(route = NavigationAuthItem.ForgotPassword.route) {

        }
    }
}