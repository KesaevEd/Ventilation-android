package com.mvptest.presentation.ui.bottommenu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mvptest.presentation.ui.HomeScreen
import com.mvptest.presentation.ui.calculation.CalculatingMainScreen
import com.mvptest.presentation.ui.myprojects.MyProjectsScreen
import com.mvptest.presentation.ui.myprojects.MyProjectsViewModel
import com.mvptest.presentation.ui.newproject.NavigationNewProjectItem
import com.mvptest.presentation.ui.newproject.NewProjectScreenFirst
import com.mvptest.presentation.ui.newproject.NewProjectScreenSecond
import com.mvptest.presentation.ui.projectdetails.ProjectDetailsScreen
import com.mvptest.presentation.ui.newproject.NewProjectViewModel
import com.mvptest.presentation.ui.newroom.NavigationNewRoomItem
import com.mvptest.presentation.ui.newroom.NewRoomScreenFirst
import com.mvptest.presentation.ui.newroom.NewRoomScreenSecond
import com.mvptest.presentation.ui.newroom.NewRoomScreenThird
import com.mvptest.presentation.ui.newroom.NewRoomViewModel
import com.mvptest.presentation.ui.projectdetails.ProjectDetailsViewModel
import com.mvptest.utils.isBottomBarInvisible
import com.mvptest.ventilation.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Calculating,
        NavigationItem.MyProjects,
        NavigationItem.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute != null && !isBottomBarInvisible(currentRoute)) {

        Card(
            modifier = Modifier
                .padding(start = 41.dp, end = 41.dp, bottom = 23.dp),
            shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
            elevation = 10.dp,

            ) {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.white),
            ) {

                Row(modifier = Modifier.padding(horizontal = 35.dp)) {
                    items.forEach { navItem ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painterResource(id = navItem.icon),
                                    contentDescription = navItem.route,
                                    modifier = Modifier
                                        .align(CenterVertically)
                                        .fillMaxHeight(0.5f)
                                )
                            },
                            selectedContentColor = colorResource(id = R.color.dark_gray_2),
                            unselectedContentColor = colorResource(id = R.color.gray),
                            selected = currentRoute == navItem.route,
                            onClick = {
                                navController.navigate(navItem.route)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    newProjectViewModel: NewProjectViewModel,
    newRoomViewModel: NewRoomViewModel,
    myProjectsViewModel: MyProjectsViewModel,
    projectDetailsViewModel: ProjectDetailsViewModel
) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        //Bottom Navigation
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Calculating.route) {
            CalculatingMainScreen(onItemClicked = {})
        }
        composable(NavigationItem.MyProjects.route) {
            MyProjectsScreen(
                myProjectsViewModel,
                onCreateNewProjectClicked = {
                    navController.navigate(
                        NavigationNewProjectItem.First.route
                    )
                },
                onItemClicked = { projectId ->
                    navController.navigate(
                        NavigationNewProjectItem.Third.route.replace(
                            oldValue = "{projectId}",
                            newValue = projectId
                        )
                    )
                })
        }
        composable(NavigationItem.Profile.route) {

        }

        //New Project Navigation
        composable(NavigationNewProjectItem.First.route) {
            NewProjectScreenFirst(
                viewModel = newProjectViewModel,
                {
                    navController.navigate(
                        NavigationNewProjectItem.Second.route
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
                })
        }

        composable(NavigationNewProjectItem.Second.route) {
            NewProjectScreenSecond(
                viewModel = newProjectViewModel,
                onBackPressed = {
                    navController.navigate(
                        NavigationNewProjectItem.First.route
                    )
                },
                onContinueButtonClick = { projectId ->
                    navController.navigate(
                        NavigationNewProjectItem.Third.route.replace(
                            oldValue = "{projectId}",
                            newValue = projectId
                        )
                    )
                })
        }

        composable(
            route = NavigationNewProjectItem.Third.route
        ) {
            val projectId = it.arguments?.getString("projectId")
            projectId?.let { id ->
                ProjectDetailsScreen(
                    projectDetailsViewModel = projectDetailsViewModel,
                    projectId = id,
                    onBackPressed = {
                        newProjectViewModel.clearState()
                        newRoomViewModel.clearState()

                        navController.navigate(
                            NavigationItem.Home.route
                        ) { popUpTo(NavigationItem.Home.route) { inclusive = true } }
                    },
                    onAddRoomPressed = { navController.navigate(NavigationNewRoomItem.First.route) },
                    onEditProjectInfoClicked = { projectId ->
                        newProjectViewModel.initEditMode(projectId)
                        navController.navigate(NavigationNewProjectItem.First.route)
                    })

            }
        }

        //New Room Navigation
        composable(NavigationNewRoomItem.First.route) {
            NewRoomScreenFirst(
                viewModel = newRoomViewModel,
                {
                    navController.navigate(
                        NavigationNewRoomItem.Second.route
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
                projectId = "TODO projectId",
                onBackPressed = {
                    navController.navigate(
                        NavigationNewRoomItem.Second.route
                    )
                },
                onSaveRoomClicked = { projectId ->
                    navController.navigate(
                        NavigationNewProjectItem.Third.route.replace(
                            oldValue = "{projectId}",
                            newValue = projectId
                        )
                    )
                }
            )
        }
    }
}




