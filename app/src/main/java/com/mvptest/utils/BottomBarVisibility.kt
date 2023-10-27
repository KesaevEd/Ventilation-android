package com.mvptest.utils

import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.calculation.NavigationCalculationItem
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem
import com.mvptest.presentation.ui.room.newroom.NavigationNewRoomItem

fun isBottomBarInvisible(route: String): Boolean = when (route) {
    NavigationNewProjectItem.First.route -> true
    NavigationNewProjectItem.Second.route -> true
    NavigationNewProjectItem.ProjectDetails.route -> true
    NavigationNewRoomItem.First.route -> true
    NavigationNewRoomItem.Second.route -> true
    NavigationNewRoomItem.Third.route -> true
    NavigationNewRoomItem.RoomDetails.route -> true
    NavigationAuthItem.Login.route -> true
    NavigationAuthItem.Registration.route -> true
    NavigationAuthItem.EmailCode.route -> true
    NavigationAuthItem.ForgotPassword.route -> true
    NavigationCalculationItem.DuctCrossSection.route -> true
    NavigationCalculationItem.AirExchange.route -> true
    NavigationCalculationItem.AirHeater.route -> true
    NavigationCalculationItem.Conditioner.route -> true
    NavigationCalculationItem.Aerodynamic.route -> true
    NavigationCalculationItem.Diffusers.route -> true
    else -> false

}