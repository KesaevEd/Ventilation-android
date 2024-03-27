package com.mvptest.presentation.ui.calculation.calculators.airductarea

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun ElementItem(
    airDuctElement: AirDuctElement,
    onDeleteClick: () -> Unit,
    onIncreaseCountClick: () -> Unit,
    onDecreaseCountClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(top = 5.dp)
            .background(colorResource(id = R.color.light_gray), shape = RoundedCornerShape(15.dp)),
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .height(68.dp)
                    .width(82.dp)
                    .padding(start = 20.dp),
                painter = painterResource(id = R.drawable.ductwork_round_correction__1_),
                contentDescription = "icon",
            )
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 5.dp)
                    .align(Alignment.CenterVertically),
            ) {
                Row() {
                    Text(
                        modifier = Modifier,
                        text = airDuctElement.titleId.toString(),
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        modifier = Modifier
                            .padding(top = 5.dp, end = 10.dp)
                            .width(10.dp)
                            .height(10.dp)
                            .clickable { onDeleteClick() },
                        painter = painterResource(id = R.drawable.ic_close),
                        tint = colorResource(id = R.color.dark_gray_2),
                        contentDescription = "icon",
                    )
                }

                airDuctElement.description?.let {
                    Text(
                        modifier = Modifier,
                        text = it,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                    )
                }

                Row() {
                    Text(
                        modifier = Modifier,
                        text = "S = ${airDuctElement.area} м2",
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(modifier = Modifier.padding(end = 10.dp)) {
                        Button(
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 4.dp),
                            onClick = { onDecreaseCountClick() },
                            shape = RoundedCornerShape(5.dp),
                            contentPadding = PaddingValues(1.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.gray)),
                            content =
                            {
                                Icon(
                                    modifier = Modifier.padding(),
                                    painter = painterResource(id = R.drawable.ic_minus),
                                    contentDescription = "image",
                                    tint = colorResource(id = R.color.dark_gray_2),
                                )
                            },
                        )

                        Box(
                            modifier = Modifier
                                .height(20.dp)
                                .background(
                                    color = colorResource(id = R.color.gray),
                                    shape = RoundedCornerShape(5.dp),
                                ),
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 7.dp).align(Alignment.Center),
                                text = "${airDuctElement.count} шт",
                                color = colorResource(id = R.color.dark_gray_2),
                                fontFamily = interFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 10.sp,
                            )
                        }
                        Button(
                            modifier = Modifier
                                .size(20.dp)
                                .padding(start = 4.dp),
                            onClick = { onIncreaseCountClick() },
                            shape = RoundedCornerShape(5.dp),
                            contentPadding = PaddingValues(1.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.gray)),
                        ) {
                            Icon(
                                modifier = Modifier.padding(),
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "image",
                                tint = colorResource(id = R.color.dark_gray_2),
                            )
                        }
                    }
                }
            }
        }
    }
}
