package com.msa.componentcompose.ui.component.instagram.circle

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import kotlinx.coroutines.delay

//-------------------------------------------------------------------------------------------------- applyInstagramAnimation
suspend fun applyInstagramAnimation(
    animatable: Animatable<Float, AnimationVector1D>,
    index: Int,
    startDelayAmount: Long,
    startDuration: Int,
    endDuration: Int,
    waitDelay: Long
) {
    delay(index * startDelayAmount)
    animatable.animateTo(
        0f, tween(
            durationMillis = startDuration,
            easing = LinearEasing
        )
    )
    delay(waitDelay)
    animatable.animateTo(
        1f, tween(
            durationMillis = endDuration,
            easing = LinearEasing
        )
    )
}
//-------------------------------------------------------------------------------------------------- applyInstagramAnimation
