package com.mvptest.utils

import com.mvptest.presentation.ui.newproject.NavigationNewProjectItem

fun isBottomBarInvisible(route: String): Boolean = when (route) {
    NavigationNewProjectItem.First.route -> true
    NavigationNewProjectItem.Second.route -> true
    else -> false

}