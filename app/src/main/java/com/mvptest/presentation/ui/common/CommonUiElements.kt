package com.mvptest.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvptest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean? = null,
    keyboardOptions: KeyboardOptions? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(colorResource(id = R.color.light_gray), shape = RoundedCornerShape(15.dp)),
        textStyle = TextStyle(
            color = colorResource(id = R.color.dark_gray),
            fontSize = 14.sp,
            fontFamily = interFamily,
            fontWeight = FontWeight.Medium
        ),
        placeholder = {
            Text(
                text = hint,
                color = colorResource(id = R.color.gray),
                fontSize = 14.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Light
            )
        },
        singleLine = singleLine ?: true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun CalculatingButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(100.dp),
        onClick = { onClick() },
        content = {
            Text(
                text = stringResource(id = R.string.calculating),
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 7.dp, bottom = 7.dp),
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium
            )
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
    )
}
