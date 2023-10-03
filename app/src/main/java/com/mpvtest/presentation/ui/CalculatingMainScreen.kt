package com.mpvtest.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mpvtest.domain.models.CalculateItem
import com.mpvtest.presentation.ui.bottommenu.BottomNavigationBar
import com.mvptest.ventilation.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatingMainScreen(onItemClicked: (itemId: Int) -> Unit) {
    val list = listOf(
        CalculateItem(id = 1, titleId = R.string.rashod),
        CalculateItem(id = 2, titleId = R.string.aerodinamika),
        CalculateItem(id = 3, titleId = R.string.diametri),
        CalculateItem(id = 4, titleId = R.string.reshetki),
        CalculateItem(id = 5, titleId = R.string.kaloriferi),
        CalculateItem(id = 6, titleId = R.string.kondicioneri)
    )
    Scaffold(bottomBar = { BottomNavigationBar() }) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            cells = GridCells.Fixed(1),
            content = {
                items(list) { ItemCard(item = it, onItemClicked = onItemClicked) }
            })
    }
}

@Composable
fun ItemCard(item: CalculateItem, onItemClicked: (id: Int) -> Unit = { }) {
    Button(
        modifier = Modifier
            .padding(10.dp),
        content = {
            Text(
                text = stringResource(id = item.titleId),
                modifier = Modifier
                    .padding(10.dp),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center,
            )
        },
        onClick = { onItemClicked(item.id) },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.background_gray))
    )
}
