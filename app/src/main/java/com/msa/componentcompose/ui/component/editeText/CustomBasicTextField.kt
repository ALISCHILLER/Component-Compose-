package com.msa.componentcompose.ui.component.editeText
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msa.componentcompose.ui.theme.barcolorlight2

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    maxLength: Int = 0,
    textSize: Int = 12,
    textAlign: TextAlign = TextAlign.Center,
    fontStyle: FontStyle = FontStyle.Normal,
    textColor: Color = Color.Black,
    corner: RoundedCornerShape = RoundedCornerShape(0.dp),
    placeholder: String = "",
    isError: Boolean = false,
    errorText: String = "",
    leadingIcon: ImageVector? = null,
    leadingColor: Color = Color.Black,
    trailingIcon: ImageVector? = null,
    onLeadingIconClick: (() -> Unit)? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text // اضافه کردن پارامتر keyboardType
) {
    val textStyle =
        TextStyle.Default.copy(fontSize = textSize.sp, textAlign = textAlign, color = textColor)
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .border(1.dp, if (isError) Color.Red else borderColor, shape = corner)
                .background(backgroundColor, shape = corner)
                .padding(3.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                leadingIcon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .size(24.dp)
                            .clickable { onLeadingIconClick?.invoke() },
                        tint = leadingColor
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    if (value.isEmpty() && placeholder.isNotEmpty()) {
                        Text(
                            text = placeholder,
                            style = textStyle.copy(
                                color = Color.Gray,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    BasicTextField(
                        value = value,
                        onValueChange = { newValue ->
                            if (newValue.length <= maxLength) {
                                onValueChange(newValue)
                            }
                        },
                        textStyle = textStyle,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = keyboardType
                        ),
                        enabled = enabled,
                        readOnly = readOnly
                    )
                }

                trailingIcon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(24.dp)
                            .clickable { onTrailingIconClick?.invoke() },
                    )
                }
            }
        }

        if (isError && errorText.isNotEmpty()) {
            Text(
                text = errorText,
                color = Color.Red,
                style = textStyle.copy(fontSize = 12.sp),
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun MyScreen() {
    val textState = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomBasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            borderColor = Color.Blue,
            backgroundColor = Color.LightGray,
            textColor = Color.Black,
            placeholder = "Enter text here...",
            isError = textState.value.isEmpty(),
            errorText = "This field cannot be empty",
            leadingIcon = Icons.Default.Search,
            onLeadingIconClick = { /* Handle leading icon click */ },
            modifier = Modifier.height(50.dp)
        )

        CustomBasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            borderColor = Color.Black,
            modifier = Modifier
                .height(50.dp)
                .weight(1f),
            backgroundColor = barcolorlight2,
            corner = RoundedCornerShape(12.dp),
            textColor = Color.White,
        )
    }

}