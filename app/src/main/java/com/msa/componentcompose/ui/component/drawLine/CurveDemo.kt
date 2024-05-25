package com.msa.componentcompose.ui.component.drawLine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
@Preview
fun CurveDemo(modifier: Modifier = Modifier) {
    val stroke3Dp = with(LocalDensity.current) { 3.dp.toPx() }
    val stroke1Dp = with(LocalDensity.current) { 1.dp.toPx() }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BezierCurve(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(100.dp),
            points = listOf(10F, 30F, 80F, 10F, 20F, 90F, 10F, 60F, 20F),
            minPoint = 0F,
            maxPoint = 100F,
            style = BezierCurveStyle.CurveStroke(
                brush = Brush.horizontalGradient(listOf(Color(0x2200FF00), Color(0xFF00FF00))),
                stroke = Stroke(width = stroke3Dp)
            ),
        )
        BezierCurve(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp, end = 30.dp)
                .height(100.dp),
            points = listOf(-0F, -40F, -10F, -90F,-10f),
            minPoint = 0F,
            maxPoint = 100F,
            style = BezierCurveStyle.Fill(
                brush = Brush.verticalGradient(listOf(Color(0x3300FF00), Color(0xFF00FF00))),
            ),
        )

        Spacer(modifier = Modifier.height(40.dp))
        BezierCurve(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp, end = 30.dp)
                .height(100.dp),
            points = listOf(20F, 80F, 30F, 70F, 20F, 90F, 10F, 60F, 20F),
            minPoint = 0F,
            maxPoint = 100F,
            style = BezierCurveStyle.StrokeAndFill(
                strokeBrush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue)),
                fillBrush = Brush.verticalGradient(listOf(Color(0xFF00FF00), Color(0x3300FF00))),
                stroke = Stroke(width = stroke1Dp)
            ),
        )
        BezierCurve(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 30.dp, end = 30.dp)
                .height(100.dp),
            points = listOf(20F, 80F, 30F, 70F, 20F, 90F, 10F, 60F, 20F),
            minPoint = 0F,
            maxPoint = 100F,
            style = BezierCurveStyle.Fill(brush = SolidColor(Color.Blue)),
        )

        Spacer(modifier = Modifier.height(40.dp))

        BezierCurve(
            modifier = Modifier
                .width(100.dp)
                .rotate(90f)
                .align(AbsoluteAlignment.Left)
                .height(100.dp),
            points = listOf(0f,20F, 50F, 30F,80f),
            minPoint = 0F,
            maxPoint = 100F,
            style = BezierCurveStyle.Fill(brush = SolidColor(Color.Blue)),
        )
    }
}




