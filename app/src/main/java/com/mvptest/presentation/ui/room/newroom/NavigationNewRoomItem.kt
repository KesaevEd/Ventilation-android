package com.mvptest.presentation.ui.room.newroom

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem
import com.mvptest.presentation.ui.project.newproject.NewProjectViewModel
import com.mvptest.presentation.ui.project.projectdetails.ProjectDetailsViewModel
import com.mvptest.presentation.ui.room.roomdetails.RoomDetailsScreen
import com.mvptest.presentation.ui.room.roomdetails.RoomDetailsViewModel

sealed class NavigationNewRoomItem(val route: String) {
    object First : NavigationNewRoomItem("new_room_first")
    object Second : NavigationNewRoomItem("new_room_second")
    object Third : NavigationNewRoomItem("new_room_third")
    object RoomDetails: NavigationNewRoomItem("room_details/{roomId}")
}

fun NavGraphBuilder.newRoomGraph(
    newProjectViewModel: NewProjectViewModel,
    newRoomViewModel: NewRoomViewModel,
    navController: NavController
){
    composable(NavigationNewRoomItem.First.route) {
        NewRoomScreenFirst(
            viewModel = newRoomViewModel,
            onCheckButtonClick = {
                navController.navigate(
                    NavigationNewRoomItem.Second.route
                )
            },
            onBackPressed = {
                navController.navigate(NavigationNewProjectItem.ProjectDetails.route) {

                    newRoomViewModel.clearState()

                    popUpTo(NavigationNewProjectItem.ProjectDetails.route) {
                        inclusive = true
                    }
                }
            })
    }

    composable(NavigationNewRoomItem.Second.route) {
        NewRoomScreenSecond(
            newRoomViewModel = newRoomViewModel,
            newProjectViewModel = newProjectViewModel,
            onBackPressed = {
                navController.navigate(
                    NavigationNewRoomItem.First.route
                )
            },
            onContinueButtonClick = { navController.navigate(NavigationNewRoomItem.Third.route) }
        )
    }

    composable(NavigationNewRoomItem.Third.route) {
        NewRoomScreenThird(
            newRoomViewModel = newRoomViewModel,
            newProjectViewModel = newProjectViewModel,
            onBackPressed = {
                navController.navigate(
                    NavigationNewRoomItem.Second.route
                )
            },
            onSaveRoomClicked = { projectId ->
                navController.navigate(
                    NavigationNewProjectItem.ProjectDetails.route.replace(
                        oldValue = "{projectId}",
                        newValue = projectId
                    )
                )
            },
            navController
        )
    }
}

fun NavGraphBuilder.roomDetailsGraph(
    roomDetailsViewModel: RoomDetailsViewModel,
    newRoomViewModel: NewRoomViewModel,
    navController: NavController
){
    composable(route = NavigationNewRoomItem.RoomDetails.route) {
        val roomId = it.arguments?.getString("roomId")
        roomId?.let { id ->
            RoomDetailsScreen(
                roomDetailsViewModel = roomDetailsViewModel,
                roomId = id,
                onBackPressed = {
                    navController.navigate(
                        NavigationNewProjectItem.ProjectDetails.route
                    )
                },
                onEditRoomClicked = { roomId ->
                    newRoomViewModel.initEditMode(roomId)
                    navController.navigate(
                        NavigationNewRoomItem.First.route.replace(
                            oldValue = "{roomId}",
                            newValue = roomId
                        )
                    )
                }
            )
        }
    }
}
