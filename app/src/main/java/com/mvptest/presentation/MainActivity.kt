package com.mvptest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mvptest.presentation.ui.bottommenu.BottomNavigationBar
import com.mvptest.presentation.ui.bottommenu.NavigationGraph
import com.mvptest.presentation.ui.myprojects.MyProjectsViewModel
import com.mvptest.presentation.ui.newproject.NewProjectViewModel
import com.mvptest.presentation.ui.newroom.NewRoomViewModel
import com.mvptest.presentation.ui.projectdetails.ProjectDetailsViewModel
import com.mvptest.presentation.ui.roomdetails.RoomDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun App() {

        val newProjectViewModel: NewProjectViewModel = viewModel()
        val newRoomViewModel: NewRoomViewModel = viewModel()
        val myProjectsViewModel: MyProjectsViewModel = viewModel()
        val projectDetailsViewModel: ProjectDetailsViewModel = viewModel()
        val roomDetailsViewModel: RoomDetailsViewModel = viewModel()

        val navController = rememberNavController()

        Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
            NavigationGraph(
                navController = navController,
                newProjectViewModel,
                newRoomViewModel,
                myProjectsViewModel,
                projectDetailsViewModel,
                roomDetailsViewModel
            )
        }
    }
}