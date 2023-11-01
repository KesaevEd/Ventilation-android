package com.mvptest.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
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
    keyboardOptions: KeyboardOptions? = null,
    enabled: Boolean? = null
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
        keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
        enabled = enabled ?: true
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation
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
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun TextTitleOfTextField(modifier: Modifier, textId: Int) {
    Text(
        modifier = modifier,
        text = stringResource(id = textId),
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}

@Composable
fun TextTitle(modifier: Modifier, text: String, colorId: Int) {
    Text(
        modifier = modifier,
        text = text,
        color = colorResource(id = colorId),
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
}

@Composable
fun BigTextTitle(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        color = colorResource(id = R.color.dark_gray),
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 27.sp
    )
}

@Composable
fun TextTitleOfText(modifier: Modifier, textId: Int) {
    Text(
        modifier = modifier,
        color = colorResource(id = R.color.dark_gray_2),
        text = stringResource(id = textId),
        fontFamily = interFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    )
}

@Composable
fun TextMediumBlack14sp(modifier: Modifier, text: String, centerText: Boolean? = null) {
    Text(
        modifier = modifier,
        color = colorResource(id = R.color.dark_gray),
        text = text,
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        textAlign = if (centerText == true) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun TextMediumGray14sp(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        color = colorResource(id = R.color.gray),
        text = text,
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}