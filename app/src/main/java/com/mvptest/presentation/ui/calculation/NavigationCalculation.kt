package com.mvptest.presentation.ui.calculation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.calculation.calculators.Aerodynamic
import com.mvptest.presentation.ui.calculation.calculators.AirExchangeScreen
import com.mvptest.presentation.ui.calculation.calculators.AirHeater
import com.mvptest.presentation.ui.calculation.calculators.Conditioner
import com.mvptest.presentation.ui.calculation.calculators.Diffusers
import com.mvptest.presentation.ui.calculation.calculators.DuctCrossSection
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem

sealed class NavigationCalculationItem(val route: String) {
    object AirExchange : NavigationCalculationItem(route = "air_exchange")
    object DuctCrossSection : NavigationCalculationItem(route = "duct_cross")
    object AirHeater : NavigationCalculationItem(route = "air_heater")
    object Diffusers : NavigationCalculationItem(route = "diffusers")
    object Aerodynamic : NavigationCalculationItem(route = "aerodynamic")
    object Conditioner : NavigationCalculationItem(route = "conditioner")
}

fun NavGraphBuilder.calculationGraph(navController: NavController) {
    navigation(startDestination = NavigationItem.Calculating.route, route = "calculation") {
        composable(NavigationItem.Calculating.route) {
            CalculatingMainScreen(onItemClicked = { route ->
                navController.navigate(route)
            })
        }
        composable(NavigationCalculationItem.AirExchange.route) {
            AirExchangeScreen(onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            })
        }
        composable(NavigationCalculationItem.DuctCrossSection.route) {
            DuctCrossSection()
        }
        composable(NavigationCalculationItem.AirHeater.route) {
            AirHeater()
        }
        composable(NavigationCalculationItem.Diffusers.route) {
            Diffusers()
        }
        composable(NavigationCalculationItem.Aerodynamic.route) {
            Aerodynamic()
        }
        composable(NavigationCalculationItem.Conditioner.route) {
            Conditioner()
        }
    }
}
