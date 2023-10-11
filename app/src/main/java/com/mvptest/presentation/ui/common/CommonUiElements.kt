package com.mvptest.presentation.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
fun CalculatingButton(modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(100.dp),
        onClick = { onClick() },
        content = {
            Text(
                text = stringResource(id = R.string.calculating),
                modifier = Modifier,
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

@Composable
fun BackOrSaveRow(onBackPressed: () -> Unit, onSaveClick: () -> Unit) {
    Row(modifier = Modifier.padding(top = 30.dp)) {
        Button(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            onClick = { onBackPressed() },
            border = BorderStroke(1.dp, color = colorResource(id = R.color.dark_gray_2)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
            content = {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .width(60.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "image",
                    tint = colorResource(id = R.color.dark_gray_2),
                )
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp),
            shape = RoundedCornerShape(16.dp),
            content = {
                Row(modifier = Modifier) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .height(11.dp)
                            .width(14.dp),
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = "image",
                        tint = Color.White,
                    )
                    Text(
                        text = stringResource(id = R.string.save_button),
                        modifier = Modifier
                            .padding(start = 15.dp),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            onClick = {
                onSaveClick()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
        )
    }
}

@Composable
fun TextTitleOfTextField(modifier: Modifier, textId: Int){
    Text(
        modifier = modifier,
        text = stringResource(id = textId),
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}

@Composable
fun TextTitle(modifier: Modifier, text: String, colorId: Int){
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
fun TextTitleOfText(modifier: Modifier, textId: Int){
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
fun TextMediumBlack14sp(modifier: Modifier, text: String){
    Text(
        modifier = modifier,
        color = colorResource(id = R.color.dark_gray),
        text = text,
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
}