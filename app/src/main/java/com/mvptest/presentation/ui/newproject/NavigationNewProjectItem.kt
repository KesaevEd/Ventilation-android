package com.mvptest.presentation.ui.newproject

sealed class NavigationNewProjectItem(var route: String) {
    object First : NavigationNewProjectItem("new_project_first")
    object Second : NavigationNewProjectItem("new_project_second")
    object Third : NavigationNewProjectItem("project_details/{projectId}")
}
