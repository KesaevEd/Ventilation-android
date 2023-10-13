package com.mvptest.presentation.ui.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.mvptest.ventilation.R

@Composable
fun HorizontalLine(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.height(1.dp).width(70.dp)) {
        drawLine(
            color = Color(0xFF515558),
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 1.dp.toPx(),
            cap = Stroke.DefaultCap
        )
    }
}