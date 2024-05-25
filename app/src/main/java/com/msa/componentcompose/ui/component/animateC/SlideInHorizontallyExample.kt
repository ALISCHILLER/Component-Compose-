package com.msa.componentcompose.ui.component.animateC

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.theme.ComponentComposeTheme

@Composable
fun SlideInHorizontallyExample() {
    var visible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),

        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "logo",
                modifier = Modifier
                    .size(110.dp, 82.dp)
                    .align(Alignment.Center) // قرار دادن تصویر در وسط
            )
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 1000)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
            )
        }

        Button(
            onClick = { visible = !visible },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Toggle Visibility")
        }
    }
}

@Preview
@Composable
private fun SlideInHorizontallyPreview() {
    ComponentComposeTheme {
        SlideInHorizontallyExample()
    }

}
