package com.mpvtest.presentation.ui.myprojects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mpvtest.domain.models.Project
import com.mpvtest.presentation.ui.bottommenu.BottomNavigationBar
import com.mpvtest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun MyProjectsScreen(onCreateNewProjectClicked: () -> Unit) {
    val list = listOf(
        Project(0, "СОШ№24", "Карпинского, 14", "02.11.2023"),
        Project(1, "Аврора", "Стахановская, 14", "12.11.2023")
    )

    Column() {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 18.dp, end = 18.dp)
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
                    )
                }
            },
            onClick = { onCreateNewProjectClicked() },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
        )
        ListContent(projectsList = list)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListContent(
    projectsList: List<Project>,
    onItemClicked: () -> Unit = { }
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(bottom = 30.dp),
        cells = GridCells.Fixed(1),
        content = {
            items(projectsList) { item ->
                ProjectItem(project = item, onItemClicked = onItemClicked)
            }
        })
}

@Composable
fun ProjectItem(
    project: Project,
    onItemClicked: () -> Unit = { }
) {
    ItemCard(item = project, onItemClicked = onItemClicked)
}

@Composable
fun ItemCard(
    item: Project,
    onItemClicked: () -> Unit = { }
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
                text = item.startDate,
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
                onClick = { onItemClicked() },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.background_gray))
            )

        }
    }
}