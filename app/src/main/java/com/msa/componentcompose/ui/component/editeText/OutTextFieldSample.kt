package com.msa.componentcompose.ui.component.editeText

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msa.componentcompose.ui.theme.barcolorlight2
import com.msa.componentcompose.ui.theme.white

@Composable
fun OutTextFieldSample(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    icon: ImageVector? = null,
    isPassword: Boolean = false,
    typeEnabled: Boolean = false,
    corner: RoundedCornerShape = RoundedCornerShape(26.dp),
    keyboardType: KeyboardType = KeyboardType.Text,
    size:Int = 1000
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= size) {
                onValueChange(newValue)
            }
        },
        singleLine = true,
        shape = corner,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = barcolorlight2,
            focusedContainerColor = barcolorlight2,
            focusedTextColor = white,
            unfocusedTextColor = white
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = keyboardType
        ),
        textStyle = TextStyle(fontSize = 13.sp)
    )
}