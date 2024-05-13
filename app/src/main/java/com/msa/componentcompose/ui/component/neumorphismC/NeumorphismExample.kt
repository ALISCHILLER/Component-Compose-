package com.msa.componentcompose.ui.component.neumorphismC

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun NeumorphismExample(modifier: Modifier = Modifier) {

    Box(
        Modifier
            .fillMaxSize()
            .offset { IntOffset(0, -20) }
            .blur(10.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            .background(Color.White, CircleShape)
    )

    Box(
        Modifier
            .fillMaxSize()
            .offset { IntOffset(0, 20) }
            .blur(10.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            .background(Color.Black.copy(alpha = .2f), CircleShape)
    )
}
