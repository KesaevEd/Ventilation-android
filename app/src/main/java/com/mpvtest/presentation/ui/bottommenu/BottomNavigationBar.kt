package com.mpvtest.presentation.ui.bottommenu

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mpvtest.presentation.ui.HomeScreen
import com.mpvtest.presentation.ui.calculation.CalculatingMainScreen
import com.mpvtest.presentation.ui.myprojects.MyProjectsScreen
import com.mvptest.ventilation.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Calculating,
        NavigationItem.MyProjects,
        NavigationItem.Profile
    )

    Card(
        modifier = Modifier
            .padding(start = 41.dp, end = 41.dp, bottom = 23.dp),
        shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
        elevation = 10.dp,

        ) {
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.white),
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

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

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Calculating.route) {
            CalculatingMainScreen(onItemClicked = {})
        }
        composable(NavigationItem.MyProjects.route) {
            MyProjectsScreen()
        }
        composable(NavigationItem.Profile.route) {

        }
    }
}




