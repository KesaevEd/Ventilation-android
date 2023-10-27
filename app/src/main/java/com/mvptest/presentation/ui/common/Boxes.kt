package com.mvptest.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.domain.calculators.CalculationResult
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun CalculatorsResult(calculationResult: CalculationResult) {

    Column(modifier = Modifier.padding(top = 20.dp)) {
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.result),
            color = colorResource(id = R.color.sand),
            fontFamily = interFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Box(
            modifier = Modifier
                .padding(top = 5.dp)
                .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.sand),
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(modifier = Modifier.padding(top = 21.dp, bottom = 21.dp)) {
                Row {
                    Text(
                        modifier = Modifier.padding(start = 25.dp),
                        text = stringResource(id = calculationResult.firstTitleId.first),
                        fontSize = 14.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(
                            id = R.color.sand
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = calculationResult.firstResult,
                        fontSize = 16.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(
                            id = R.color.dark_gray_2
                        )
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp, end = 25.dp),
                        text = stringResource(id = calculationResult.firstTitleId.second),
                        fontSize = 16.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(
                            id = R.color.dark_gray_2
                        )
                    )
                }

                if(calculationResult.secondResult != null) {
                    Row(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            modifier = Modifier.padding(start = 25.dp),
                            text = stringResource(id = calculationResult.secondTitleId.first),
                            fontSize = 14.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(
                                id = R.color.sand
                            )
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = calculationResult.secondResult,
                            fontSize = 16.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(
                                id = R.color.dark_gray_2
                            )
                        )
                        Text(
                            modifier = Modifier.padding(start = 3.dp, end = 25.dp),
                            text = stringResource(id = calculationResult.secondTitleId.second),
                            fontSize = 16.sp,
                            fontFamily = interFamily,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(
                                id = R.color.dark_gray_2
                            )
                        )
                    }
                }
            }
        }
    }
}