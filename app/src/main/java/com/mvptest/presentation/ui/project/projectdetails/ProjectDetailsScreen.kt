package com.mvptest.presentation.ui.project.projectdetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.presentation.ui.common.MyAlertDialog
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun ProjectDetailsScreen(
    projectDetailsViewModel: ProjectDetailsViewModel,
    projectId: String,
    onBackPressed: () -> Unit,
    onAddRoomPressed: (projectId: String) -> Unit,
    onEditProjectInfoClicked: (projectId: String) -> Unit,
    onRoomItemClicked: (roomId: String, projectId: String) -> Unit
) {

    var tempProjectId = ""

    if (projectId != "{projectId}") {
        tempProjectId = projectId
    } else {
        tempProjectId = projectDetailsViewModel.temporalProjectId
    }

    projectDetailsViewModel.getProjectById(tempProjectId)

    val openMore = remember { mutableStateOf(false) }
    val openSendDialog = remember { mutableStateOf(false) }
    val openDeleteDialog = remember { mutableStateOf(false) }

    if (openDeleteDialog.value) {
        MyAlertDialog(
            titleId = R.string.ask_delete_project,
            confirmButtonText = R.string.yes_delete,
            onCancelClicked = {
                openDeleteDialog.value = false
            },
            onConfirmClicked = {
                openDeleteDialog.value = false
                projectDetailsViewModel.deleteProject()
                onBackPressed()
            })
    }

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp, top = 18.dp)
                .background(
                    color = colorResource(id = R.color.dark_blue),
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .align(TopEnd)
                    .padding(top = 16.dp, end = 25.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clickable { openMore.value = !openMore.value }) {
                    Icon(
                        modifier = Modifier.height(50.dp).width(50.dp),
                        painter = painterResource(id = R.drawable.ic_ellipse),
                        contentDescription = "image"
                    )
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_more),
                        contentDescription = "image",
                        tint = colorResource(id = R.color.gray)
                    )
                }
                if (openMore.value) {
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable { onEditProjectInfoClicked.invoke(projectId) }) {
                        Icon(
                            modifier = Modifier.height(50.dp).width(50.dp),
                            painter = painterResource(id = R.drawable.ic_ellipse),
                            contentDescription = "image"
                        )
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "image",
                            tint = colorResource(id = R.color.gray)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable { openSendDialog.value = true }) {
                        Icon(
                            modifier = Modifier.height(50.dp).width(50.dp),
                            painter = painterResource(id = R.drawable.ic_ellipse),
                            contentDescription = "image"
                        )
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_send),
                            contentDescription = "image",
                            tint = colorResource(id = R.color.gray)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .clickable { openDeleteDialog.value = true }) {
                        Icon(
                            modifier = Modifier.height(50.dp).width(50.dp),
                            painter = painterResource(id = R.drawable.ic_ellipse),
                            contentDescription = "image"
                        )
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "image",
                            tint = colorResource(id = R.color.gray)
                        )
                    }
                }
            }
            Column(modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp)) {
                Text(
                    modifier = Modifier.padding(),
                    text = projectDetailsViewModel.state.title ?: "",
                    fontSize = 22.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
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
                    text = projectDetailsViewModel.state.address ?: "",
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
                    text = projectDetailsViewModel.state.startDate ?: "",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stringResource(id = R.string.contact),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.gray),
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )

                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = projectDetailsViewModel.state.contact ?: "",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )

                Text(
                    modifier = Modifier.padding(top = 15.dp),
                    text = stringResource(id = R.string.contact_phone),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.gray),
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )

                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = projectDetailsViewModel.state.contactPhone ?: "",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )
            }
        }

        if (projectDetailsViewModel.state.rooms == null || projectDetailsViewModel.state.rooms!!.isEmpty()) {
            Text(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(CenterHorizontally),
                text = stringResource(id = R.string.empty_rooms),
                fontSize = 16.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium
            )

        } else {
            ListContent(
                projectsList = projectDetailsViewModel.state.rooms ?: emptyList()
            ) { roomId -> onRoomItemClicked.invoke(roomId, projectId) }
        }

        Row(modifier = Modifier.padding(top = 30.dp, start = 18.dp, end = 18.dp)) {
            Button(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                onClick = {
                    projectDetailsViewModel.clearState()
                    onBackPressed()
                },
                border = BorderStroke(1.dp, color = colorResource(id = R.color.dark_gray_2)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                content = {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(60.dp),
                        painter = painterResource(id = R.drawable.ic_log_out),
                        contentDescription = "image",
                        tint = colorResource(id = R.color.dark_gray_2),
                    )
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(16.dp),
                content = {
                    Row(modifier = Modifier) {
                        Icon(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .height(20.dp)
                                .width(20.dp),
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "image",
                            tint = Color.White,
                        )
                        Text(
                            text = stringResource(id = R.string.add_room),
                            modifier = Modifier
                                .padding(start = 15.dp),
                            color = colorResource(id = R.color.white),
                            textAlign = TextAlign.Center,
                        )
                    }
                },
                onClick = { onAddRoomPressed.invoke(tempProjectId) },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )

        }
    }
}

@Composable
fun ListContent(
    projectsList: List<RoomItemUiEntity>,
    onItemClicked: (roomId: String) -> Unit = { }
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(start = 18.dp, end = 18.dp),
        columns = GridCells.Fixed(1),
        content = {
            items(projectsList) { item ->
                ProjectDetailsItem(project = item, onItemClicked = onItemClicked)
            }
        })
}

@Composable
fun ProjectDetailsItem(
    project: RoomItemUiEntity,
    onItemClicked: (roomId: String) -> Unit = { }
) {
    ProjectDetailsItemCard(item = project, onItemClicked = onItemClicked)
}

@Composable
fun ProjectDetailsItemCard(
    item: RoomItemUiEntity,
    onItemClicked: (roomId: String) -> Unit = { }
) {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
            .background(
                colorResource(id = R.color.light_gray),
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.title,
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 25.dp, top = 29.dp, bottom = 29.dp)
            )
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier.padding(end = 25.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_gray_2)),
                shape = RoundedCornerShape(8.dp),
                onClick = { onItemClicked(item.id) },
                content = {
                    Text(
                        text = stringResource(id = R.string.open),
                        color = Color.White,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                }
            )
        }
    }
}