package com.msa.componentcompose.ui.component.switchC


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msa.componentcompose.R // مسیر فایل تصویر را اینجا قرار دهید

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    switchColor: Color = MaterialTheme.colorScheme.primary,
    text: String = "",
    textColor: Color = Color.Black,
    textSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    backgroundPainter: Painter,
    checkedThumbPainter: Painter,
    uncheckedThumbPainter: Painter
) {
    Box(
        modifier = modifier
            .background(Color.Transparent)
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(16.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = textSize.sp,
                fontWeight = fontWeight,
                modifier = Modifier.padding(end = 8.dp)
            )
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Transparent,
                    uncheckedThumbColor = Color.Transparent,
                    checkedTrackColor = switchColor.copy(alpha = 0.5f),
                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                ),
                thumbContent = {
                    val thumbPainter = if (checked) checkedThumbPainter else uncheckedThumbPainter
                    Image(
                        painter = thumbPainter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Transparent, CircleShape)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomSwitchPreview() {
    val isChecked = remember { mutableStateOf(true) }
    val backgroundPainter = painterResource(id = R.drawable.switch_body_night) // مسیر فایل تصویر پس زمینه را اینجا قرار دهید
    val checkedThumbPainter = painterResource(id = R.drawable.switch_btn_sun) // مسیر فایل تصویر در حالت تایید را اینجا قرار دهید
    val uncheckedThumbPainter = painterResource(id = R.drawable.switch_btn_moon) // مسیر فایل تصویر در حالت غیر تایید را اینجا قرار دهید

    CustomSwitch(
        checked = isChecked.value,
        onCheckedChange = { isChecked.value = it },
        switchColor = Color.Green,
        text = "Enable Notifications",
        textColor = Color.Black,
        textSize = 18,
        fontWeight = FontWeight.Bold,
        backgroundPainter = backgroundPainter,
        checkedThumbPainter = checkedThumbPainter,
        uncheckedThumbPainter = uncheckedThumbPainter,
        modifier = Modifier
            .size(200.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
    )
}
