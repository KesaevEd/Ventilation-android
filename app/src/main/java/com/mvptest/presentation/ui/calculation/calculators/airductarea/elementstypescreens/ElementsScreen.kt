package com.mvptest.presentation.ui.calculation.calculators.airductarea.elementstypescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mvptest.presentation.ui.common.RoundedTextField
import com.mvptest.presentation.ui.common.TextTitleOfTextField
import com.mvptest.ventilation.R

@Preview
@Composable
fun ductworkRoundArea() {
    var length by remember {
        mutableStateOf(value = 0.0)
    }

    var diameter by remember {
        mutableStateOf(value = 0.0)
    }

    var count by remember {
        mutableStateOf(value = 0)
    }

    Row(modifier = Modifier.padding(18.dp).fillMaxWidth()) {
        Image(
            modifier = Modifier.height(200.dp)
                .width(200.dp),
            painter = painterResource(id = R.drawable.ductwork_round_correction__1_),
            contentDescription = "icon",
        )

        Column(modifier = Modifier.padding(start = 15.dp)) {
            TextTitleOfTextField(
                modifier = Modifier.padding(top = 20.dp),
                textId = R.string.length,
            )
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = length.toString(),
                onValueChange = {
                },
                hint = stringResource(id = R.string.value_m),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 20.dp),
                textId = R.string.diameter,
            )
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = diameter.toString(),
                onValueChange = {
                },
                hint = stringResource(id = R.string.value_mm),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            TextTitleOfTextField(
                modifier = Modifier.padding(top = 20.dp),
                textId = R.string.counts,
            )
            RoundedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = length.toString(),
                onValueChange = {
                },
                hint = stringResource(id = R.string.count),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}
