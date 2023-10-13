package com.mvptest.presentation.ui.calculation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.calculation.calculators.AerodynamicScreen
import com.mvptest.presentation.ui.calculation.calculators.AirExchangeScreen
import com.mvptest.presentation.ui.calculation.calculators.AirHeaterScreen
import com.mvptest.presentation.ui.calculation.calculators.ConditionerScreen
import com.mvptest.presentation.ui.calculation.calculators.DiffusersScreen
import com.mvptest.presentation.ui.calculation.calculators.DuctCrossSectionScreen

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
            DuctCrossSectionScreen()
        }
        composable(NavigationCalculationItem.AirHeater.route) {
            AirHeaterScreen()
        }
        composable(NavigationCalculationItem.Diffusers.route) {
            DiffusersScreen()
        }
        composable(NavigationCalculationItem.Aerodynamic.route) {
            AerodynamicScreen()
        }
        composable(NavigationCalculationItem.Conditioner.route) {
            ConditionerScreen()
        }
    }
}
