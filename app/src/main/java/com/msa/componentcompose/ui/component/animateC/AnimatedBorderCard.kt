package com.msa.componentcompose.ui.component.animateC

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.theme.Typography


// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 2.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Color.Gray, Color.White)),
    animationDuration: Int = 10000,
    onCardClick: () -> Unit = {},
    content: // Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Infinite Colors"
    )

    Surface(
        modifier = modifier
            .clip(shape)
            .clickable { onCardClick() },
        shape = shape
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            color = MaterialTheme.colorScheme.surface,
            shape = shape
        ) {
            content()
        }
    }
}

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun AnimatedBorderCardPreview() {
    AnimatedBorderCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
        ,
        shape = RoundedCornerShape(8.dp),
        gradient = Brush.sweepGradient(listOf(Color.Magenta,Color.Cyan)),
        onCardClick = {

        }
    ){

        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "سلام ایران",
                style = Typography.labelMedium
            )
            Text(
                text = "Hi Iran",
                style = Typography.labelMedium

            )
            Text(
                text = "persian",
                style = Typography.labelMedium
            )
            Image(
                painter = painterResource(id = R.drawable.flag_iran),
                contentDescription = "icon"
            )
        }
    }
}


// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun AnimatedBorderCardRadar(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 2.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Color.Gray, Color.White)),
    animationDuration: Int = 10000,
    onCardClick: () -> Unit = {},
    content: // Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Infinite Colors"
    )

    Surface(
        modifier = modifier
            .clip(shape)
            .clickable { onCardClick() },
        shape = shape
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    //drawContent()
                },
            color = MaterialTheme.colorScheme.surface,
            shape = shape
        ) {
            content()
        }
    }
}


@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun AnimatedBorderCardRadarPreciew() {
    AnimatedBorderCardRadar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
        ,
        shape = RoundedCornerShape(8.dp),
        gradient = Brush.sweepGradient(listOf(Color.Magenta,Color.Cyan)),
        onCardClick = {

        }
    ){

        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "سلام ایران",
                style = Typography.labelMedium
            )
            Text(
                text = "Hi Iran",
                style = Typography.labelMedium

            )
            Text(
                text = "persian",
                style = Typography.labelMedium
            )
            Image(
                painter = painterResource(id = R.drawable.flag_iran),
                contentDescription = "icon"
            )
        }
    }
}