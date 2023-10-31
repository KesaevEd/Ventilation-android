package com.mvptest.presentation.ui.home

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun HomeScreen(navController: NavController, homeScreenViewModel: HomeScreenViewModel) {
    val activity = LocalContext.current as AppCompatActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    homeScreenViewModel.fetchUserProjects()

    Column(modifier = Modifier.padding(start = 18.dp, top = 18.dp, end = 18.dp)) {
        HomeItem(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) { navController.navigate(NavigationNewProjectItem.First.route) },
            icon = R.drawable.ic_add,
            titleId = R.string.new_project,
            subTitleId = R.string.new_project_subtitle,
            backgroundColorId = R.color.dark_gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        )
        {
            HomeItem(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { navController.navigate(NavigationItem.Calculating.route) },
                icon = R.drawable.ic_calculator,
                titleId = R.string.calculating_bottomnav,
                subTitleId = R.string.calculator_subtitile,
                backgroundColorId = R.color.sand
            )
            HomeItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { navController.navigate(NavigationItem.MyProjects.route) },
                icon = R.drawable.ic_notes,
                titleId = R.string.projects_title,
                subTitleId = R.string.projects_subtitle,
                backgroundColorId = R.color.dark_blue
            )
        }
    }
}

@Composable
fun HomeItem(modifier: Modifier, icon: Int, titleId: Int, subTitleId: Int, backgroundColorId: Int) {
    Card(
        modifier = modifier,
        backgroundColor = colorResource(id = backgroundColorId),
        shape = RoundedCornerShape(size = 25.dp),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp)) {
            Box() {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ellipse),
                    contentDescription = "image"
                )
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = icon),
                    contentDescription = "image",
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier.padding(top = 70.dp),
                text = stringResource(id = titleId),
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = stringResource(id = subTitleId),
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

        }
    }
}