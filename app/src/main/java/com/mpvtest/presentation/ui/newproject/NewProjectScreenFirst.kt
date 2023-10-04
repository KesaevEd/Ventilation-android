package com.mpvtest.presentation.ui.newproject


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpvtest.presentation.ui.common.RoundedTextField
import com.mpvtest.utils.interFamily
import com.mvptest.ventilation.R

@Composable
fun NewProjectScreenFirst(onCheckButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var newItem by remember { mutableStateOf("") }
        var newTextFieldModifier by remember { mutableStateOf(Modifier.height(60.dp).fillMaxWidth()) }

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.creating_project),
            fontSize = 20.sp,
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold
        )

        TextFieldWithCheckButton(onTextChanged = { text ->
            newItem = text
            if(newItem.isNotEmpty()){
                newTextFieldModifier = Modifier.height(60.dp)
            }else{
                newTextFieldModifier = Modifier.height(60.dp).fillMaxWidth()
            }
        }, newItem = newItem, newTextFieldModifier, onCheckButtonClick)
    }
}

@Composable
fun TextFieldWithCheckButton(
    onTextChanged: (String) -> Unit,
    newItem: String,
    modifier: Modifier,
    onCheckButtonClick: () -> Unit
) {
    var textValue by remember {
        mutableStateOf(value = "")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 18.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RoundedTextField(
            modifier = modifier,
            value = textValue,
            onValueChange = { newValue ->
                textValue = newValue
                onTextChanged(newValue)
            },
            hint = stringResource(id = R.string.write_project_name)
        )

        if (newItem.isNotEmpty()) {
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .padding(start = 10.dp),
                onClick = { onCheckButtonClick() },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.dark_gray_2))
            )
            {
                Icon(
                    modifier = Modifier.padding(),
                    painter = painterResource(id = R.drawable.ic_check),
                    tint = Color.White,
                    contentDescription = "check"
                )
            }
        }
    }
}