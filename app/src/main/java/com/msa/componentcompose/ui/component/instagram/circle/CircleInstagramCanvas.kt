package com.msa.componentcompose.ui.component.instagram.circle

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp

//-------------------------------------------------------------------------------------------------- CircleInstagramCanvas
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CircleInstagramCanvas(
    modifier: Modifier,
    totalArcs: Int,
    animatables: Array<Animatable<Float, AnimationVector1D>>,
    eachAngle: Float,
    rotation: Float,
    strokeWidth: Dp,
    strokeStartColor: Color,
    strokeEndColor: Color
) {

    Canvas(
        modifier = modifier
    ) {
        (0 until totalArcs).forEach { angle ->
            val animatable = animatables[angle]
            val animationAmount = animatable.value
            val offset = ((1f - animationAmount) / 2f) * eachAngle
            val startAngle = rotation + -90f + offset + (angle * eachAngle)
            val offsetAmount = size.width * 0.1f
            drawArc(
                brush = Brush.linearGradient(
                    Pair(0f, strokeStartColor), Pair(1f, strokeEndColor),
                    start = Offset(x = size.width - offsetAmount, y = offsetAmount),
                    end = Offset(x = offsetAmount, y = size.width - offsetAmount)
                ),
                startAngle = startAngle,
                sweepAngle = eachAngle * animationAmount,
                useCenter = false,
                size = Size(width = size.width, height = size.width),
                style = Stroke(
                    width = strokeWidth.toPx() * animationAmount,
                    cap = StrokeCap.Round
                )
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- CircleInstagramCanvas