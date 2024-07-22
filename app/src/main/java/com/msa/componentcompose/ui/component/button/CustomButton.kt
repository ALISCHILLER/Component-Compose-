package com.msa.componentcompose.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msa.componentcompose.ui.theme.OrangeStatus
import com.msa.componentcompose.ui.theme.white

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    btnColor: Color = Color.Yellow,
    textColor: Color = Color.White,
    fontSize: Int = 12,
    fontWeight: FontWeight = FontWeight.Bold,
    shape: CornerBasedShape = RoundedCornerShape(16.dp),
    padding: Dp = 2.dp,
    icon: ImageVector? = null,
    iconSize: Dp = 24.dp,
    buttonHeight: Dp = 48.dp,
    contentPadding: Dp = 12.dp,
    enabled: Boolean = true,
    textAlign: TextAlign = TextAlign.Center
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = btnColor),
        shape = shape,
        modifier = modifier
            .padding(padding)
            .size(height = buttonHeight, width = Dp.Unspecified),
        enabled = enabled,
        contentPadding = PaddingValues(contentPadding)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(iconSize)
                        .padding(end = 8.dp)
                )
            }
            Text(
                text = text,
                color = textColor,
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
                textAlign = textAlign
            )
        }
    }
}

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun CustomButtonPreview() {
    CustomButton(
        text = "OK",
        onClick = {},
        btnColor = OrangeStatus,
        textColor = white,
        fontSize = 13,
        fontWeight = FontWeight.Bold,
        shape = RoundedCornerShape(10.dp)
    )
}