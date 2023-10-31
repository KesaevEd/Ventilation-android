package com.mvptest.presentation.ui.calculation.calculators.aerodynamic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mvptest.presentation.ui.common.AerodynamicElementsDropDown
import com.mvptest.presentation.ui.common.AirDuctSizeAerodynamicDropDown
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextMediumBlack14sp
import com.mvptest.presentation.ui.common.TextMediumGray14sp
import com.mvptest.ventilation.R

@Composable
fun SectionItem(
    item: AerodynamicSection,
    aerodynamicViewModel: AerodynamicViewModel,
    onRemoveSection: (sectionIndex: Int) -> Unit
) {

    val sectionIndex = aerodynamicViewModel.state.sections.indexOf(item)

    var airFlow by remember {
        mutableStateOf(value = aerodynamicViewModel.state.sections[sectionIndex].airFlow)
    }

    var length by remember {
        mutableStateOf(value = aerodynamicViewModel.state.sections[sectionIndex].length)
    }

    var size by remember {
        mutableStateOf(value = aerodynamicViewModel.state.sections[sectionIndex].ductSize)
    }

    var calculatedDuctSize by remember {
        mutableStateOf(value = aerodynamicViewModel.state.sections[sectionIndex].calculateDuctSize)
    }

    var elements by remember {
        mutableStateOf(value = aerodynamicViewModel.state.sections[sectionIndex].elements)
    }

    Column() {
        Row(
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth()
        ) {
            TextMediumGray14sp(
                modifier = Modifier
                    .weight(0.05f)
                    .align(Alignment.CenterVertically),
                text = item.number.toString()
            )
            RoundedTextField(
                modifier = Modifier
                    .weight(0.2f)
                    .padding(end = 2.dp),
                value = airFlow, onValueChange = { text ->
                    airFlow = text
                    aerodynamicViewModel.setAirFlow(sectionIndex, text)
                }, hint = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            RoundedTextField(
                modifier = Modifier
                    .weight(0.15f)
                    .padding(end = 2.dp),
                value = length, onValueChange = { text ->
                    length = text
                    aerodynamicViewModel.setLength(sectionIndex, text)
                }, hint = "",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Box(
                modifier = Modifier
                    .weight(0.25f)
                    .padding(end = 2.dp)
            ) {
                AirDuctSizeAerodynamicDropDown(
                    modifier = Modifier, selected = size, onItemClick = { text ->
                        size = text
                        aerodynamicViewModel.setDuctSize(sectionIndex, text)
                    })
//                Icon(
//                    modifier = Modifier
//                        .align(Alignment.CenterEnd)
//                        .padding(end = 15.dp),
//                    painter = painterResource(id = R.drawable.ic_arrow_down),
//                    contentDescription = "image",
//                    tint = colorResource(
//                        id = R.color.gray
//                    )
//                )
            }
            Column(modifier = Modifier.weight(0.35f)) {
                elements.forEachIndexed { index, aerodynamicElement ->
                    ElementItem(aerodynamicElement, onItemClicked = { newItem ->
                        aerodynamicViewModel.setElement(sectionIndex, index, newItem)
                    }, onRemoveClicked = {
                        if (index > 0) {
                            val newList = elements.toMutableList()
                            newList.removeAt(index)
                            elements = newList
                            aerodynamicViewModel.deleteElement(sectionIndex, index)
                        } else if (index == 0) {
                            onRemoveSection.invoke(index)
                        }
                    })
                }
            }
        }

        Row() {
            if( calculatedDuctSize != null) {
                TextMediumBlack14sp(modifier = Modifier, text = stringResource(id = R.string.recommended_duct_size) + " " + calculatedDuctSize!!)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(top = 5.dp, end = 34.dp),
                shape = RoundedCornerShape(8.dp),
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
                    }
                },
                onClick = {
                    val newList = elements.toMutableList()
                    newList.add(AerodynamicElement("", 0, 0.0))
                    elements = newList
                    aerodynamicViewModel.addElement(sectionIndex)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
        }
    }
}

@Composable
fun ElementItem(
    item: AerodynamicElement,
    onItemClicked: (AerodynamicElement) -> Unit,
    onRemoveClicked: (AerodynamicElement) -> Unit
) {
    Box {
        AerodynamicElementsDropDown(item, onItemClick = { onItemClicked.invoke(it) })
        Icon(
            modifier = Modifier
                .padding(top = 5.dp, end = 5.dp)
                .align(Alignment.TopEnd)
                .width(15.dp)
                .height(15.dp)
                .clickable { onRemoveClicked.invoke(item) },
            painter = painterResource(id = R.drawable.ic_close),
            tint = colorResource(id = R.color.gray),
            contentDescription = "icon"
        )
    }
}