package com.mpvtest.presentation.ui.newproject

sealed class NavigationNewProjectItem(var route: String) {
    object First : NavigationNewProjectItem("new_project_first")
    object Second : NavigationNewProjectItem("new_project_second")
    object Third : NavigationNewProjectItem("new_project_third")
}
