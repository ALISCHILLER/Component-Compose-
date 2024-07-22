package com.msa.componentcompose.ui.component.animateC

import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.msa.componentcompose.ui.theme.ComponentComposeTheme

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun AutoSizeChangingText() {
    val infiniteTransition = rememberInfiniteTransition()
    val textSize by infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = 16f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Text(
        text = "Hello, Jetpack Compose!",
        fontSize = textSize.sp,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun PreviewAutoSizeChangingText() {
    ComponentComposeTheme {
        AutoSizeChangingText()
    }

}
