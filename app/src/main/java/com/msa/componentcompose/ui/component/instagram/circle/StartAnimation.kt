package com.msa.componentcompose.ui.component.instagram.circle

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import com.msa.componentcompose.ui.component.instagram.circle.applyInstagramAnimation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//-------------------------------------------------------------------------------------------------- startInstagramAnimation
fun CoroutineScope.startInstagramAnimation(
    animatables: Array<Animatable<Float, AnimationVector1D>>,
    startDelayAmount: Long,
    startDuration: Int,
    endDuration: Int,
    waitDelay: Long
) {
    animatables.forEachIndexed { index, animatable ->
        launch {
            applyInstagramAnimation(
                animatable = animatable,
                index = index,
                startDelayAmount = startDelayAmount,
                startDuration = startDuration,
                endDuration = endDuration,
                waitDelay = waitDelay
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- startInstagramAnimation
