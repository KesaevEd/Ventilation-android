package com.mpvtest.utils

import com.mpvtest.presentation.ui.newproject.NavigationNewProjectItem

fun isBottomBarInvisible(route: String): Boolean = when (route) {
    NavigationNewProjectItem.First.route -> true
    NavigationNewProjectItem.Second.route -> true
    NavigationNewProjectItem.Third.route -> true
    else -> false

}