package com.msa.componentcompose.ui.component.instagram.circle

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.ui.component.instagram.InstagramEffect

//-------------------------------------------------------------------------------------------------- CircleInstagramAnimationButton
@Composable
fun CircleInstagramAnimationButton(
    modifier: Modifier,
    isAnimate: Boolean,
    strokeWidth: Dp,
    strokeStartColor: Color,
    strokeEndColor: Color,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        shape = CircleShape
    ) {
        if (isAnimate)
            InstagramEffect(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp),
                strokeWidth = strokeWidth,
                strokeStartColor = strokeStartColor,
                strokeEndColor = strokeEndColor
            )
        content()
    }
}
//-------------------------------------------------------------------------------------------------- CircleInstagramAnimationButton
