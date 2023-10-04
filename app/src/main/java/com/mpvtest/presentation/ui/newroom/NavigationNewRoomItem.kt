package com.mpvtest.presentation.ui.newroom

import com.mpvtest.presentation.ui.newproject.NavigationNewProjectItem

sealed class NavigationNewRoomItem(val route: String) {
    object First : NavigationNewRoomItem("new_room_first")
    object Second : NavigationNewRoomItem("new_room_second")
    object Third : NavigationNewRoomItem("new_room_third")
}
