package com.mvptest.presentation.ui.calculation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.mvptest.domain.models.CalculateItem
import com.mvptest.domain.models.CalculationType
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun CalculatingMainScreen(onItemClicked: (itemId: Int) -> Unit) {
    val list = listOf(
        CalculateItem(
            type = CalculationType.AIR_EXCHANGE,
            titleId1 = R.string.calculating_bottomnav,
            titleId = R.string.rashod,
            iconId = R.drawable.ic_air_exchange
        ),
        CalculateItem(
            type = CalculationType.AERODYNAMIC,
            titleId1 = R.string.calculating_bottomnav,
            titleId = R.string.aerodinamika,
            iconId = R.drawable.ic_aerodynamic
        ),
        CalculateItem(
            type = CalculationType.DUCT_CROSS_SECTIONS,
            titleId1 = R.string.selection,
            titleId = R.string.diametri,
            iconId = R.drawable.ic_air_duct
        ),
        CalculateItem(
            type = CalculationType.DIFFUSERS,
            titleId1 = R.string.calculating_bottomnav,
            titleId = R.string.reshetki,
            iconId = R.drawable.ic_diffusers
        ),
        CalculateItem(
            type = CalculationType.AIR_HEATER,
            titleId1 = R.string.calculating_bottomnav,
            titleId = R.string.kaloriferi,
            iconId = R.drawable.ic_air_heater
        ),
        CalculateItem(
            type = CalculationType.CONDITIONER,
            titleId1 = R.string.calculating_bottomnav,
            titleId = R.string.kondicioneri,
            iconId = R.drawable.ic_conditioner
        )
    )

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        content = {
            items(list) { ItemCard(item = it){onItemClicked} }
        })
}


@Composable
fun ItemCard(item: CalculateItem, onItemClicked: (id: CalculationType) -> Unit = { }) {
    Box(
        modifier = Modifier.background(
            color = colorResource(id = R.color.sand),
            shape = RoundedCornerShape(25.dp)
        ),
    )
    {
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 15.dp,
                    end = 15.dp,
                    bottom = 25.dp
                )
                .clickable { onItemClicked(item.type) }
        ) {
            Row(
                Modifier.wrapContentHeight()
            ) {
                Text(
                    text = stringResource(id = item.titleId1),
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .fillMaxHeight(),
                    color = colorResource(id = R.color.white),
                    fontFamily = interFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier) {
                    Icon(
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp),
                        painter = painterResource(id = R.drawable.ic_ellipse_white),
                        contentDescription = "icon",
                        tint = colorResource(id = R.color.light_sand)
                    )
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = item.iconId),
                        contentDescription = "icon",
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
            Text(
                text = stringResource(id = item.titleId),
                modifier = Modifier,
                color = colorResource(id = R.color.white),
                fontFamily = interFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}