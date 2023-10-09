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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }

//        val ib1: ImageButton = findViewById(R.id.b1)
//        val b1: Button = findViewById(R.id.rashod)
//
//        ib1.setOnClickListener {
//            val intent = Intent(this, Vozduhoobmen::class.java)
//            startActivity(intent)
//        }
//        b1.setOnClickListener {
//            val intent = Intent(this, Vozduhoobmen::class.java)
//            startActivity(intent)
//        }
//
//        val ib7: ImageButton = findViewById(R.id.b7)
//        val b7: Button = findViewById(R.id.kondicioneri)
//
//        ib7.setOnClickListener {
//            val intent = Intent(this, Conditional::class.java)
//            startActivity(intent)
//        }
//        b7.setOnClickListener {
//            val intent = Intent(this, Conditional::class.java)
//            startActivity(intent)
//        }
//
//        val ib5: ImageButton = findViewById(R.id.b5)
//        val b5: Button = findViewById(R.id.reshetki)
//
//        ib5.setOnClickListener {
//            val intent = Intent(this, Reshetki::class.java)
//            startActivity(intent)
//        }
//        b5.setOnClickListener {
//            val intent = Intent(this, Reshetki::class.java)
//            startActivity(intent)
//        }
//
//        val ib4: ImageButton = findViewById(R.id.b4)
//        val b4: Button = findViewById(R.id.sechenie)
//
//        ib4.setOnClickListener {
//            val intent = Intent(this, Sechenie::class.java)
//            startActivity(intent)
//        }
//        b4.setOnClickListener {
//            val intent = Intent(this, Sechenie::class.java)
//            startActivity(intent)
//        }
//
//        val ib6: ImageButton = findViewById(R.id.b6)
//        val b6: Button = findViewById(R.id.kaloriferi)
//
//        ib6.setOnClickListener {
//            val intent = Intent(this, Kalorifer::class.java)
//            startActivity(intent)
//        }
//        b6.setOnClickListener {
//            val intent = Intent(this, Kalorifer::class.java)
//            startActivity(intent)
//        }
//
//        val ib2: ImageButton = findViewById(R.id.b2)
//        val b2: Button = findViewById(R.id.aerodinamica)
//
//        ib2.setOnClickListener {
//            val intent = Intent(this, Aerodinamica::class.java)
//            startActivity(intent)
//        }
//        b2.setOnClickListener {
//            val intent = Intent(this, Aerodinamica::class.java)
//            startActivity(intent)
//        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    private fun App() {

        val newProjectViewModel: NewProjectViewModel = viewModel()
        val newRoomViewModel: NewRoomViewModel = viewModel()
        val myProjectsViewModel: MyProjectsViewModel = viewModel()
        val projectDetailsViewModel: ProjectDetailsViewModel = viewModel()

        val navController = rememberNavController()

        Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
            NavigationGraph(
                navController = navController,
                newProjectViewModel,
                newRoomViewModel,
                myProjectsViewModel,
                projectDetailsViewModel
            )
        }
    }
}

object NavigationKeys {

    object Arg {
        const val BLOG_ID = "BlogName"
    }

    object Route {
        const val HOME = "home"
        const val PROJECT_LIST = "projects_list"
//        const val BLOG_DETAILS = "$BLOG_LIST/{$BLOG_ID}"
    }
}