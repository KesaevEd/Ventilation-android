package com.mvptest.presentation.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun ButtonWithText(modifier: Modifier, textId: Int, buttonColor: Int? = null, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        content = {
            Row(modifier = Modifier) {
                Text(
                    text = stringResource(id = textId),
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp),
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Center,
                    fontFamily = interFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        },
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(
                buttonColor ?: R.color.dark_gray_2
            )
        )
    )
}

@Composable
fun CalculatingButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(100.dp),
        onClick = { onClick() },
        content = {
            Text(
                text = stringResource(id = R.string.calculating),
                modifier = Modifier,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium
            )
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
    )
}

@Composable
fun BackOrSaveRow(onBackPressed: () -> Unit, onSaveClick: () -> Unit) {
    Row(modifier = Modifier.padding(top = 30.dp)) {
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
                            .height(11.dp)
                            .width(14.dp),
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = "image",
                        tint = Color.White,
                    )
                    Text(
                        text = stringResource(id = R.string.save_button),
                        modifier = Modifier
                            .padding(start = 15.dp),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            onClick = {
                onSaveClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
        )
    }
}

@Composable
fun ButtonIconAndText(modifier: Modifier, iconId: Int, textId: Int, onClick: () -> Unit) {
    Box(modifier = modifier) {
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            shape = RoundedCornerShape(8.dp),
            content = {
                Row(modifier = Modifier) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .align(Alignment.CenterVertically)
                            .height(20.dp)
                            .width(20.dp),
                        painter = painterResource(id = iconId),
                        contentDescription = "image",
                        tint = Color.White,
                    )
                    Text(
                        text = stringResource(id = textId),
                        modifier = Modifier
                            .padding(start = 15.dp, end = 6.dp),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            },
            onClick = {
                onClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
        )
    }
}