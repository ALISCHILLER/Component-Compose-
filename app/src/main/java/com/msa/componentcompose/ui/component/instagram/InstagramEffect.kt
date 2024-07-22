package com.msa.componentcompose.ui.component.instagram

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.ui.component.instagram.circle.CircleInstagramCanvas
import com.msa.componentcompose.ui.component.instagram.circle.startInstagramLoading

//-------------------------------------------------------------------------------------------------- InstagramEffect
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun InstagramEffect(
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 3.dp,
    strokeStartColor: Color = Color(0xffa52c9d),
    strokeEndColor: Color = Color(0xfff7c269)
) {
    val totalArcs = 25
    val eachAngle = 360f / totalArcs.toFloat()
    val startDelayAmount = 13L
    val startDuration = 700
    val endDuration = (startDuration * 0.6f).toInt()
    val waitDelay: Long = 300
    val coroutineScope = rememberCoroutineScope()

    val animatables = remember {
        Array(totalArcs) {
            Animatable(initialValue = 1f, visibilityThreshold = 0f)
        }
    }

    val rotation = remember {
        Animatable(initialValue = 0f, visibilityThreshold = 0f)
    }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            startInstagramLoading(
                eachAngle = eachAngle,
                rotation = rotation,
                coroutineScope = coroutineScope,
                animatables = animatables,
                startDuration = startDuration,
                startDelayAmount = startDelayAmount,
                endDuration = endDuration,
                waitDelay = waitDelay
            )
        }
    }

    CircleInstagramCanvas(
        modifier = modifier,
        totalArcs = totalArcs,
        animatables = animatables,
        eachAngle = eachAngle,
        rotation = rotation.value,
        strokeWidth = strokeWidth,
        strokeStartColor = strokeStartColor,
        strokeEndColor = strokeEndColor
    )
}
//-------------------------------------------------------------------------------------------------- InstagramEffect







