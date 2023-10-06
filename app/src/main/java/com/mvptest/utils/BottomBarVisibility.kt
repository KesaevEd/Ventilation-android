package com.mvptest.utils

import com.mvptest.presentation.ui.newproject.NavigationNewProjectItem
import com.mvptest.presentation.ui.newroom.NavigationNewRoomItem

fun isBottomBarInvisible(route: String): Boolean = when (route) {
    NavigationNewProjectItem.First.route -> true
    NavigationNewProjectItem.Second.route -> true
    NavigationNewProjectItem.Third.route -> true
    NavigationNewRoomItem.First.route -> true
    NavigationNewRoomItem.Second.route -> true
    NavigationNewRoomItem.Third.route -> true
    else -> false

}