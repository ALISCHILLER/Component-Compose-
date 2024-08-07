package com.msa.componentcompose.ui.component.lottiefile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.msa.componentcompose.R

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun AnimatedPreloader(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.loading
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}


@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun preciew() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        // Blurred background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    renderEffect = BlurEffect(90f, 90f) // Adjust the radius as needed
                }
                .background(Color.White.copy(alpha = 0.5f))
        )

        // Foreground content
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AnimatedPreloader(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.Center)
            )
        }
    }
}