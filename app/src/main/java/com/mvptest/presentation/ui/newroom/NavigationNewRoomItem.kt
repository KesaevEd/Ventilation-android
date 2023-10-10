package com.mvptest.presentation.ui.newroom

sealed class NavigationNewRoomItem(val route: String) {
    object First : NavigationNewRoomItem("new_room_first")
    object Second : NavigationNewRoomItem("new_room_second")
    object Third : NavigationNewRoomItem("new_room_third")
    object RoomDetails: NavigationNewRoomItem("room_details/{roomId}")
}
