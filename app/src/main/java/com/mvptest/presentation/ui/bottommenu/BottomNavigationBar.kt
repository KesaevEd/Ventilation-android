package com.mvptest.presentation.ui.bottommenu

import android.content.Context
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
import com.mvptest.presentation.ui.home.HomeScreen
import com.mvptest.presentation.ui.auth.LoginScreen
import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.auth.UserAuthViewModel
import com.mvptest.presentation.ui.auth.authGraph
import com.mvptest.presentation.ui.calculation.calculationGraph
import com.mvptest.presentation.ui.calculation.calculators.aerodynamic.AerodynamicViewModel
import com.mvptest.presentation.ui.home.HomeScreenViewModel
import com.mvptest.presentation.ui.myprojects.MyProjectsScreen
import com.mvptest.presentation.ui.myprojects.MyProjectsViewModel
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem
import com.mvptest.presentation.ui.project.newproject.NewProjectViewModel
import com.mvptest.presentation.ui.project.newproject.newProjectGraph
import com.mvptest.presentation.ui.room.newroom.NewRoomViewModel
import com.mvptest.presentation.ui.project.projectdetails.ProjectDetailsViewModel
import com.mvptest.presentation.ui.room.newroom.newRoomGraph
import com.mvptest.presentation.ui.room.newroom.roomDetailsGraph
import com.mvptest.presentation.ui.room.roomdetails.RoomDetailsViewModel
import com.mvptest.utils.isBottomBarInvisible
import com.mvptest.ventilation.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Calculating,
        NavigationItem.MyProjects
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
    homeScreenViewModel: HomeScreenViewModel,
    newProjectViewModel: NewProjectViewModel,
    newRoomViewModel: NewRoomViewModel,
    myProjectsViewModel: MyProjectsViewModel,
    projectDetailsViewModel: ProjectDetailsViewModel,
    roomDetailsViewModel: RoomDetailsViewModel,
    userAuthViewModel: UserAuthViewModel,
    aerodynamicViewModel: AerodynamicViewModel,
    context: Context
) {

    var startDestination = ""
    if (userAuthViewModel.token == null) {
        startDestination = NavigationAuthItem.Login.route
    } else {
        // TODO check token in remote db
        startDestination = NavigationItem.Home.route
    }

    NavHost(navController, startDestination = startDestination) {

        composable(route = NavigationAuthItem.Login.route) {
            LoginScreen(
                userAuthViewModel,
                context,
                forgotPasswordClick = {},
                logInClick = { navController.navigate(NavigationItem.Home.route) },
                logUpClick = { navController.navigate(NavigationAuthItem.Registration.route) },
            )
        }

        //Bottom Navigation
        composable(NavigationItem.Home.route) {
            HomeScreen(navController, homeScreenViewModel)
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
                        NavigationNewProjectItem.ProjectDetails.route.replace(
                            oldValue = "{projectId}",
                            newValue = projectId
                        )
                    )
                })
        }

        authGraph(navController, userAuthViewModel, context)

        newProjectGraph(
            context,
            newProjectViewModel,
            newRoomViewModel,
            projectDetailsViewModel,
            navController
        )

        newRoomGraph(newProjectViewModel, newRoomViewModel, navController)

        roomDetailsGraph(roomDetailsViewModel, newRoomViewModel, navController)

        calculationGraph(navController, context, aerodynamicViewModel, newRoomViewModel)
    }
}




