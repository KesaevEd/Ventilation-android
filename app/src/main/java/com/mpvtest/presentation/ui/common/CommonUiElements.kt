package com.mpvtest.presentation.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    paddingTrailingIconStart: Dp = 0.dp,
    hintTextId: Int,
    leadingIcon: (@Composable() () -> Unit)? = null
) {
    var state = rememberSaveable(saver = TextFieldValue.Saver) { TextFieldValue() }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (leadingIcon != null) {
            leadingIcon()
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = paddingTrailingIconStart)
        ) {
            TextField(
                value = state,
                onValueChange = { state = it }
            )
            if (state.text.isEmpty()) {
                Text(
                    text = stringResource(id = hintTextId)
                )
            }
        }
    }
}
