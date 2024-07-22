package com.msa.componentcompose.ui.component.animateC

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntOffset
import com.msa.componentcompose.ui.theme.ComponentComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun SquareToCircleAnimation() {

    val scope = rememberCoroutineScope()
    val animateWidth = remember { Animatable(0f, 1.0f) }
    val yOffset = remember { Animatable(0f,1.0f) }
    val animatedWidth  = remember { Animatable(0f,1.0f) }

    LaunchedEffect(Unit) {
        scope.launch {
            animateWidth.animateTo(
                targetValue = 1.0f,
                animationSpec = tween(durationMillis = 5000)
            )
            yOffset.animateTo(
                targetValue = 100.0f,
                animationSpec = tween(durationMillis = 5000, easing = FastOutSlowInEasing)
            )
        }
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .offset(y = yOffset.value.dp)
            .background(
                color = Color.Red,
                shape = RoundedCornerShape((50.dp * animateWidth.value))
            )
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
@Preview(showBackground = true)
fun MyApp() {
    ComponentComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            SquareToCircleAnimation()
        }
    }
}

@ExperimentalMaterial3Api
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun App() {
    MyApp()
}
