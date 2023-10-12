package com.mvptest.presentation.ui.common

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mvptest.data.ventilationconstans.roomDestinations
import com.mvptest.ventilation.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoomDestinationDropDown(onItemClick: (destination: String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    var selectedDestination by remember { mutableStateOf("") }

    Box(
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {},
            content = {
                RoundedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            expanded = !expanded
                        },
                    value = selectedDestination,
                    onValueChange = {},
                    hint = stringResource(id = R.string.room_destination),
                    enabled = false
                )

                if (roomDestinations.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        roomDestinations.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item) },
                                onClick = {
                                    onItemClick.invoke(item)
                                    selectedDestination = item
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}