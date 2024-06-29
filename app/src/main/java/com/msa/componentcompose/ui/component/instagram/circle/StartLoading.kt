package com.msa.componentcompose.ui.component.instagram.circle

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//-------------------------------------------------------------------------------------------------- startInstagramLoading
suspend fun startInstagramLoading(
    eachAngle: Float,
    rotation: Animatable<Float, AnimationVector1D>,
    coroutineScope: CoroutineScope,
    animatables: Array<Animatable<Float, AnimationVector1D>>,
    startDelayAmount: Long,
    startDuration: Int,
    endDuration: Int,
    waitDelay: Long
) {
    val rotationAnimationDuration =
        startDuration + endDuration + waitDelay

    coroutineScope.launch {
        startInstagramAnimation(
            animatables = animatables,
            startDelayAmount = startDelayAmount,
            startDuration = startDuration,
            endDuration = endDuration,
            waitDelay = waitDelay
        )
    }
    coroutineScope.launch {
        rotation.animateTo(
            targetValue = rotation.value + eachAngle * 3,
            animationSpec = tween(
                durationMillis = (2f * rotationAnimationDuration).toInt(),
                easing = LinearEasing
            )
        )
    }
    delay(rotationAnimationDuration + 500)
}
//-------------------------------------------------------------------------------------------------- startInstagramLoading
