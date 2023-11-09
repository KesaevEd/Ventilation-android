package com.mvptest.presentation.ui.myprojects

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mvptest.domain.models.Project
import com.mvptest.presentation.ui.auth.NavigationAuthItem
import com.mvptest.presentation.ui.bottommenu.NavigationItem
import com.mvptest.presentation.ui.common.RegisterOfferDialog
import com.mvptest.presentation.ui.home.HomeScreenViewModel
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun MyProjectsScreen(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController,
    viewModel: MyProjectsViewModel,
    onCreateNewProjectClicked: () -> Unit,
    onItemClicked: (id: String) -> Unit
) {
    val token = homeScreenViewModel.getToken()

    viewModel.getMyProjects()

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

    Column(
        Modifier.padding(top = 10.dp)
    ) {
        if (viewModel.state.projects != null && viewModel.state.projects!!.isNotEmpty()) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 18.dp, end = 18.dp, bottom = 10.dp)
                    .align(CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Row(modifier = Modifier) {
                        Icon(
                            modifier = Modifier
                                .align(CenterVertically)
                                .height(20.dp)
                                .width(20.dp),
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "image",
                            tint = Color.White,
                        )
                        Text(
                            text = stringResource(id = R.string.create_project),
                            modifier = Modifier
                                .padding(17.dp),
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center,
                            fontFamily = interFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                },
                onClick = { onCreateNewProjectClicked() },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        }
        if (viewModel.state.projects != null && viewModel.state.projects!!.isEmpty()) {
            Text(
                modifier = Modifier
                    .align(alignment = CenterHorizontally)
                    .padding(top = 200.dp),
                text = stringResource(id = R.string.empty_projects),
                fontSize = 16.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                color = colorResource(
                    id = R.color.dark_gray
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 18.dp, end = 18.dp)
                    .align(CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Row(modifier = Modifier) {
                        Icon(
                            modifier = Modifier
                                .align(CenterVertically)
                                .height(20.dp)
                                .width(20.dp),
                            painter = if (token != null) painterResource(id = R.drawable.ic_add) else painterResource(
                                id = R.drawable.ic_lock
                            ),
                            contentDescription = "image",
                            tint = Color.White,
                        )
                        Text(
                            text = stringResource(id = R.string.create_project),
                            modifier = Modifier
                                .padding(17.dp),
                            color = if (token != null) colorResource(id = R.color.white) else colorResource(
                                id = R.color.lock_gray1
                            ),
                            textAlign = TextAlign.Center,
                            fontFamily = interFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                },
                onClick = {
                    if(token != null) {
                        onCreateNewProjectClicked()
                    } else {
                        openDialog.value = true
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        } else {
            ListContent(
                projectsList = viewModel.state.projects ?: emptyList()
            ) { itemId -> onItemClicked.invoke(itemId) }
        }
    }

    BackHandler {
        navController.navigate(NavigationItem.Home.route) {
            popUpTo(NavigationItem.Home.route) {
                inclusive = true
            }
        }
    }
}

@Composable
fun ListContent(
    projectsList: List<Project>,
    onItemClicked: (id: String) -> Unit = { }
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(bottom = 80.dp),
        columns = GridCells.Fixed(1),
        content = {
            items(projectsList) { item ->
                ProjectItem(project = item, onItemClicked = onItemClicked)
            }
        })
}

@Composable
fun ProjectItem(
    project: Project,
    onItemClicked: (id: String) -> Unit = { }
) {
    ItemCard(item = project, onItemClicked = onItemClicked)
}

@Composable
fun ItemCard(
    item: Project,
    onItemClicked: (id: String) -> Unit = { }
) {
    Card(
        modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 18.dp),
        backgroundColor = colorResource(id = R.color.dark_blue),
        shape = RoundedCornerShape(size = 25.dp),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp)) {

            Text(
                modifier = Modifier.padding(top = 25.dp),
                text = item.title,
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = stringResource(id = R.string.project_address),
                fontSize = 12.sp,
                color = colorResource(id = R.color.gray),
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = item.address,
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = stringResource(id = R.string.start_date),
                fontSize = 12.sp,
                color = colorResource(id = R.color.gray),
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = item.startDate ?: "",
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp, top = 20.dp),
                shape = RoundedCornerShape(13.dp),
                content = {
                    Text(
                        text = stringResource(id = R.string.open_project),
                        modifier = Modifier
                            .padding(5.dp),
                        color = colorResource(id = R.color.dark_gray_2),
                        textAlign = TextAlign.Center,
                    )
                },
                onClick = { onItemClicked.invoke(item.id) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.background_gray))
            )

        }
    }
}