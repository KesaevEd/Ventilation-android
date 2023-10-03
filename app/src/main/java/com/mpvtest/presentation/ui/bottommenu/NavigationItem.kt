package com.mpvtest.presentation.ui.bottommenu

import com.mvptest.ventilation.R

sealed class NavigationItem(var route: String, var icon: Int) {
    object Home : NavigationItem("home", R.drawable.ic_home)
    object Calculating : NavigationItem("calculating", R.drawable.ic_calculator)
    object MyProjects : NavigationItem("my_project", R.drawable.ic_notes)
    object Profile : NavigationItem("account", R.drawable.ic_profile)
}