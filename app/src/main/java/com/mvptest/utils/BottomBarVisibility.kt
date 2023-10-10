package com.mvptest.utils

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
    else -> false

}