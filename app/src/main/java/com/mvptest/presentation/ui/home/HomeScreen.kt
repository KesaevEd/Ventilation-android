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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.common.MyAlertDialog
import com.mvptest.presentation.ui.common.RegisterOfferDialog
import com.mvptest.presentation.ui.project.newproject.NavigationNewProjectItem
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun HomeScreen(navController: NavController, homeScreenViewModel: HomeScreenViewModel) {
    val activity = LocalContext.current as AppCompatActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val openDialog = remember { mutableStateOf(false) }
    if (openDialog.value) {
        RegisterOfferDialog(
            onConfirmClicked = {
                openDialog.value = false
                navController.navigate(NavigationAuthItem.Login.route)
            },
            onCancelClicked = {
                openDialog.value = false
            }
        )
    }

    val token = homeScreenViewModel.getToken()

    homeScreenViewModel.fetchUserProjects()

    Column(modifier = Modifier.padding(start = 18.dp, top = 18.dp, end = 18.dp)) {
        HomeItem(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    if (token != null) {
                        navController.navigate(NavigationNewProjectItem.First.route)
                    } else {
                        openDialog.value = true
                    }
                },
            icon = if (token != null) R.drawable.ic_add else R.drawable.ic_lock,
            titleId = R.string.new_project,
            subTitleId = R.string.new_project_subtitle,
            backgroundColorId = R.color.dark_gray,
            token == null,
            isNewProject = true
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
                subTitleId = R.string.calculators_subtitile,
                backgroundColorId = R.color.sand,
                false,
                isNewProject = false
            )
            HomeItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        if (token != null) {
                            navController.navigate(NavigationItem.MyProjects.route)
                        } else {
                          openDialog.value = true
                        }
                    },
                icon = if (token != null) R.drawable.ic_notes else R.drawable.ic_lock,
                titleId = R.string.projects_title,
                subTitleId = R.string.projects_subtitle,
                backgroundColorId = R.color.dark_blue,
                token == null,
                false
            )
        }
    }
}

@Composable
fun HomeItem(
    modifier: Modifier,
    icon: Int,
    titleId: Int,
    subTitleId: Int,
    backgroundColorId: Int,
    isLock: Boolean,
    isNewProject: Boolean
) {
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
                color = if (isLock && isNewProject) colorResource(id = R.color.lock_gray1) else if (isLock && !isNewProject) colorResource(
                    id = R.color.lock_gray2
                ) else Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = stringResource(id = subTitleId),
                fontSize = 14.sp,
                color = if (isLock && isNewProject) colorResource(id = R.color.lock_gray1) else if (isLock && !isNewProject) colorResource(
                    id = R.color.lock_gray2
                ) else Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

        }
    }
}