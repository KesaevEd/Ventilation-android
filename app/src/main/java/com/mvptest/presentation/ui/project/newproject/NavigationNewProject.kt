package com.mvptest.presentation.ui.project.newproject

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.project.projectdetails.ProjectDetailsScreen
import com.mvptest.presentation.ui.project.projectdetails.ProjectDetailsViewModel
import com.mvptest.presentation.ui.room.newroom.NavigationNewRoomItem
import com.mvptest.presentation.ui.room.newroom.NewRoomViewModel

sealed class NavigationNewProjectItem(var route: String) {
    object First : NavigationNewProjectItem("new_project_first")
    object Second : NavigationNewProjectItem("new_project_second")
    object ProjectDetails : NavigationNewProjectItem("project_details/{projectId}")
}

fun NavGraphBuilder.newProjectGraph(
    context: Context,
    newProjectViewModel: NewProjectViewModel,
    newRoomViewModel: NewRoomViewModel,
    projectDetailsViewModel: ProjectDetailsViewModel,
    navController: NavController,
) {
    navigation(
        startDestination = NavigationNewProjectItem.First.route,
        route = "new_project",
    ) {
        composable(NavigationNewProjectItem.First.route) {
            NewProjectScreenFirst(
                viewModel = newProjectViewModel,
                {
                    navController.navigate(
                        NavigationNewProjectItem.Second.route,
                    )
                },
                {
                    navController.navigate(NavigationItem.Home.route) {
                        newProjectViewModel.clearState()
                        newRoomViewModel.clearState()

                        popUpTo(NavigationItem.Home.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }

        composable(NavigationNewProjectItem.Second.route) {
            NewProjectScreenSecond(
                context = context,
                viewModel = newProjectViewModel,
                onBackPressed = {
                    navController.navigate(
                        NavigationNewProjectItem.First.route,
                    )
                },
                onContinueButtonClick = { projectId ->
                    navController.navigate(
                        NavigationNewProjectItem.ProjectDetails.route.replace(
                            oldValue = "{projectId}",
                            newValue = projectId,
                        ),
                    )
                },
            )
        }

        composable(
            route = NavigationNewProjectItem.ProjectDetails.route,
        ) {
            val projectId = it.arguments?.getString("projectId")
            projectId?.let { id ->
                ProjectDetailsScreen(
                    context = context,
                    projectDetailsViewModel = projectDetailsViewModel,
                    projectId = id,
                    onBackPressed = {
                        newProjectViewModel.clearState()
                        newRoomViewModel.clearState()

                        navController.navigate(
                            NavigationItem.MyProjects.route,
                        ) { popUpTo(NavigationItem.MyProjects.route) { inclusive = true } }
                    },
                    onAddRoomPressed = { projectId ->
                        newProjectViewModel.initEditMode(projectId)
                        navController.navigate(NavigationNewRoomItem.First.route)
                    },
                    onEditProjectInfoClicked = { projectId ->
                        newProjectViewModel.initEditMode(projectId)
                        navController.navigate(NavigationNewProjectItem.First.route)
                    },
                    onRoomItemClicked = { roomId, projectId ->
                        newProjectViewModel.projectId = projectId
                        navController.navigate(
                            NavigationNewRoomItem.RoomDetails.route.replace(
                                oldValue = "{roomId}",
                                newValue = roomId,
                            ),
                        )
                    },
                )
            }
        }
    }
}
