package com.mvptest.presentation.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.mvptest.presentation.ui.calculation.ventilationconstans.airDuctSizes
import com.mvptest.presentation.ui.calculation.ventilationconstans.ductSizeListAerodynamic
import com.mvptest.presentation.ui.calculation.ventilationconstans.roomDestinations
import com.mvptest.presentation.ui.calculation.ventilationconstans.ventElements
import com.mvptest.presentation.ui.calculation.calculators.aerodynamic.AerodynamicElement
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AirDuctSizeDropDown(modifier: Modifier? = Modifier, onItemClick: (size: String) -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    var selectedSize by remember { mutableStateOf("") }

    Box(
        modifier = modifier ?: Modifier
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
                    value = selectedSize,
                    onValueChange = {},
                    hint = stringResource(id = R.string.choose_size),
                    enabled = false
                )

                if (airDuctSizes.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        airDuctSizes.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item) },
                                onClick = {
                                    onItemClick.invoke(item)
                                    selectedSize = item
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AirDuctSizeAerodynamicDropDown(
    modifier: Modifier? = Modifier,
    selected: String?,
    onItemClick: (size: String) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedSize by remember { mutableStateOf(selected) }

    Box(
        modifier = modifier ?: Modifier
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
                    value = selectedSize ?: "",
                    onValueChange = {},
                    hint = "",
                    enabled = false
                )

                if (ductSizeListAerodynamic.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        ductSizeListAerodynamic.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item) },
                                onClick = {
                                    onItemClick.invoke(item)
                                    selectedSize = item
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PairObjectsDropDown(
    hintId: Int,
    list: Array<Pair<String, Int>>,
    onItemClick: (first: String, second: Int) -> Unit,
    isMaxWidth: Boolean? = true
) {

    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }

    val modifier = if (isMaxWidth != false) Modifier
        .fillMaxWidth()
        .clickable {
            expanded = !expanded
        } else Modifier
        .clickable {
            expanded = !expanded
        }

    Box(
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {},
            content = {
                RoundedTextField(
                    modifier = modifier,
                    value = if (selected.length < 31) selected else (selected.substring(
                        startIndex = 0,
                        endIndex = 31
                    ) + "..."),
                    onValueChange = {},
                    hint = stringResource(id = hintId),
                    enabled = false
                )

                if (list.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        list.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item.first) },
                                onClick = {
                                    onItemClick.invoke(item.first, item.second)
                                    selected = item.first
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShortPairObjectsDropDown(
    hintId: Int,
    list: Array<Pair<String, Int>>,
    onItemClick: (first: String, second: Int) -> Unit,
    isMaxWidth: Boolean? = true
) {

    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }

    val modifier = if (isMaxWidth != false) Modifier
        .fillMaxWidth()
        .clickable {
            expanded = !expanded
        } else Modifier
        .clickable {
            expanded = !expanded
        }

    Box(
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {},
            content = {
                RoundedTextField(
                    modifier = modifier,
                    value = if (selected.length < 17) selected else (selected.substring(
                        startIndex = 0,
                        endIndex = 17
                    ) + "..."),
                    onValueChange = {},
                    hint = stringResource(id = hintId),
                    enabled = false
                )

                if (list.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        list.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item.first) },
                                onClick = {
                                    onItemClick.invoke(item.first, item.second)
                                    selected = item.first
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AerodynamicElementsDropDown(
    item: AerodynamicElement,
    onItemClick: (element: AerodynamicElement) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(item.name) }

    val modifier = Modifier
        .clickable {
            expanded = !expanded
        }

    Box(modifier = Modifier.padding(top = 2.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {},
            content = {
                RoundedTextField(
                    modifier = modifier,
                    value = if (selected.length < 31) selected else (selected.substring(
                        startIndex = 0,
                        endIndex = 31
                    ) + "..."),
                    onValueChange = {},
                    hint = "Отвод 30°",
                    enabled = false
                )

                if (ventElements.isNotEmpty()) {
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        ventElements.forEach { item ->
                            DropdownMenuItem(
                                content = { Text(text = item.name) },
                                onClick = {
                                    onItemClick.invoke(item)
                                    selected = item.name
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            })
    }
}