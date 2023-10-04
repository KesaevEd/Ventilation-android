package com.mpvtest.presentation.ui.newproject

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.mpvtest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun NewProjectScreenThird(viewModel: NewProjectViewModel, onBackPressed:() -> Unit, onAddRoomPressed:() -> Unit) {
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
            Column(modifier = Modifier.padding(start = 25.dp, top = 25.dp, bottom = 25.dp)) {
                Text(
                    modifier = Modifier.padding(),
                    text = viewModel.state.title ?: "",
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
                    text = viewModel.state.address ?: "",
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
                    text = viewModel.state.startDate ?: "",
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
                    text = viewModel.state.contact ?: "",
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
                    text = viewModel.state.contactPhone ?: "",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Light
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(top = 40.dp)
                .align(CenterHorizontally),
            text = stringResource(id = R.string.empty_rooms),
            fontSize = 16.sp,
            fontFamily = interFamily,
            fontWeight = FontWeight.Medium
        )

        Row(modifier = Modifier.padding(top = 30.dp, start = 18.dp, end = 18.dp)) {
            Button(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                onClick = { onBackPressed() },
                border = BorderStroke(1.dp, color = colorResource(id = R.color.dark_gray_2)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                content = {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(60.dp),
                        painter = painterResource(id = R.drawable.ic_arrow_left),
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
                onClick = { onAddRoomPressed() },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )

        }
    }
}