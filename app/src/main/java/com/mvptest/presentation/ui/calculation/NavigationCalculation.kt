package com.mvptest.presentation.ui.calculation

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.calculation.calculators.aerodynamic.AerodynamicScreen
import com.mvptest.presentation.ui.calculation.calculators.aerodynamic.AerodynamicViewModel
import com.mvptest.presentation.ui.calculation.calculators.airechange.AirExchangeScreen
import com.mvptest.presentation.ui.calculation.calculators.airheater.AirHeaterScreen
import com.mvptest.presentation.ui.calculation.calculators.conditioner.ConditionerScreen
import com.mvptest.presentation.ui.calculation.calculators.diffusers.DiffusersScreen
import com.mvptest.presentation.ui.calculation.calculators.ductcross.DuctCrossSectionScreen

sealed class NavigationCalculationItem(val route: String) {
    object AirExchange : NavigationCalculationItem(route = "air_exchange/{fromProject}")
    object DuctCrossSection : NavigationCalculationItem(route = "duct_cross/{fromProject}")
    object AirHeater : NavigationCalculationItem(route = "air_heater/{fromProject}")
    object Diffusers : NavigationCalculationItem(route = "diffusers/{fromProject}")
    object Aerodynamic : NavigationCalculationItem(route = "aerodynamic/{fromProject}")
    object Conditioner : NavigationCalculationItem(route = "conditioner/{fromProject}")
}

fun NavGraphBuilder.calculationGraph(navController: NavController, context: Context, aerodynamicViewModel: AerodynamicViewModel) {
    navigation(startDestination = NavigationItem.Calculating.route, route = "calculation") {
        composable(NavigationItem.Calculating.route) {
            CalculatingMainScreen(onItemClicked = { route ->
                navController.navigate(route)
            })
        }
        composable(NavigationCalculationItem.AirExchange.route) {
            val fromProject = it.arguments?.getString("fromProject")
            AirExchangeScreen(fromProject ?: "false", onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {})
        }
        composable(NavigationCalculationItem.DuctCrossSection.route) {
            val fromProject = it.arguments?.getString("fromProject")
            DuctCrossSectionScreen(fromProject ?: "false", onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {

            })
        }
        composable(NavigationCalculationItem.AirHeater.route) {
            val fromProject = it.arguments?.getString("fromProject")
            AirHeaterScreen(context = context,fromProject ?: "false", onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {

            })
        }
        composable(NavigationCalculationItem.Diffusers.route) {
            val fromProject = it.arguments?.getString("fromProject")
            DiffusersScreen(fromProject ?: "false", onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {

            })
        }
        composable(NavigationCalculationItem.Aerodynamic.route) {
            val fromProject = it.arguments?.getString("fromProject")
            AerodynamicScreen(fromProject ?: "false", aerodynamicViewModel, onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {

            })
        }
        composable(NavigationCalculationItem.Conditioner.route) {
            val fromProject = it.arguments?.getString("fromProject")
            ConditionerScreen(fromProject ?: "false", onBackPressed = {
                navController.navigate(NavigationItem.Calculating.route) {
                    popUpTo(
                        NavigationItem.Calculating.route
                    ) {
                        inclusive = true
                    }
                }
            }, onSaveClicked = {

            })
        }
    }
}
