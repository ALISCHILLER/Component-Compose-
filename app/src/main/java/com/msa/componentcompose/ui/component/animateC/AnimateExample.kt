@file:OptIn(ExperimentalAnimationApi::class)

package com.msa.componentcompose.ui.component.animateC

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import com.msa.componentcompose.ui.theme.ComponentComposeTheme

@Composable
fun AnimateExample(modifier: Modifier = Modifier) {
    ComponentComposeTheme {
        // AnimatedVisibilityExample()

        ///   AnimatedBorderRadius()


        //AnimatedTransitionColor()
        AnimatedTransitionColor2()
    }
}
//        Crossfade(targetState = ) {
//
//        }2

@Composable
fun AnimatedTransitionColor2(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        var isVisible by remember {
            mutableStateOf(false)
        }
        var isRound by remember {
            mutableStateOf(false)
        }

        Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text(text = "action")

        }



        AnimatedContent(
            targetState = isVisible,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f),

            content = { isVisibel ->
                if (isVisibel) {
                    Box(modifier = modifier.background(Color.Red))
                } else
                    Box(modifier = modifier.background(Color.Green))
            },
            transitionSpec = {
                //   fadeIn() with fadeOut()
                slideInHorizontally(
                    initialOffsetX = {
                        if(isVisible) it else -it
                    }
                ) with slideOutHorizontally(
                    targetOffsetX = {if(isVisible) -it else it}
                )
            }
        )


    }
}

@Composable
fun AnimatedTransitionColor(modifier: Modifier = Modifier) {
    ComponentComposeTheme {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            var isVisible by remember {
                mutableStateOf(false)
            }
            var isRound by remember {
                mutableStateOf(false)
            }

            Button(onClick = {
                isVisible = !isVisible
                isRound = !isRound
            }) {
                Text(text = "action")

            }
            val transition = rememberInfiniteTransition()
            val color by transition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Box(
                modifier = modifier
                    .padding(vertical = 15.dp, horizontal = 15.dp)
                    .size(200.dp)
                    .background(color)
            ) {

            }

        }
    }


}

@Composable
fun AnimatedBorderRadius(modifier: Modifier = Modifier) {
    ComponentComposeTheme {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            var isVisible by remember {
                mutableStateOf(false)
            }
            var isRound by remember {
                mutableStateOf(false)
            }

            Button(onClick = {
                isVisible = !isVisible
                isRound = !isRound
            }) {
                Text(text = "action")

            }

            val transition = updateTransition(
                targetState = isRound,
                label = null
            )

            //  val borderRadius by animateIntAsState(
//                targetValue = if (isRound) 40 else 20,

//                animationSpec = tween(
//                    durationMillis = 3000,
//                    delayMillis = 500,
////                   easing = LinearEasing
//                )

///               animationSpec = spring(
//                   dampingRatio = Spring.DampingRatioHighBouncy,
//                   stiffness = Spring.StiffnessVeryLow
//              )

//            )


            val borderRadius by transition.animateInt(
                transitionSpec = { tween(2000) },
                label = "borderRadius",
                targetValueByState = { isRound ->
                    if (isRound) 100 else 0
                }
            )
            val color by transition.animateColor(
                transitionSpec = { tween(1000) },
                label = "color",
                targetValueByState = { isRound ->
                    if (isRound) Color.Green else Color.Red
                }
            )


            Box(
                modifier = modifier
                    .padding(vertical = 15.dp, horizontal = 15.dp)
                    .size(200.dp)
                    .clip(RoundedCornerShape(borderRadius))
                    .background(color)
            ) {

            }
        }
    }

}

@Composable
fun AnimatedVisibilityExample(modifier: Modifier = Modifier) {
    ComponentComposeTheme {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            var isVisible by remember {
                mutableStateOf(false)
            }

            Button(onClick = {
                isVisible = !isVisible
            }) {
                Text(text = "action")

            }

            AnimatedVisibility(
                visible = isVisible,
                enter = slideInHorizontally() + fadeIn(),
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Box(modifier = modifier.background(Color.Red)) {

                }

            }

        }
    }
}


@Preview
@Composable
private fun AnimatedVisibilityExamplePreview() {
    ///AnimatedVisibilityExample()
}

@Preview
@Composable
private fun AnimateExamplePreview() {
    AnimateExample()
}