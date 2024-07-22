@file:Suppress("DEPRECATION")
@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.componentcompose.ui.component.pager


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.wear.compose.material.MaterialTheme.colors
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.msa.componentcompose.R

import kotlin.math.absoluteValue


@Preview
@OptIn(ExperimentalPagerApi::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun Sample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("horiz pager with transition title") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colors.surface
                ),
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        HorizontalPagerWithOffsetTransition(Modifier.padding(padding))
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalCoilApi::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun HorizontalPagerWithOffsetTransition(modifier: Modifier = Modifier) {
    HorizontalPager(
        count = 10,
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = modifier.fillMaxSize()
    ) { page ->
        Card(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Box {
                Image(
                    painter = rememberImagePainter(
                        data = rememberRandomSampleImageUrl(width = 600),
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                )

                ProfilePicture(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        // We add an offset lambda, to apply a light parallax effect
                        .offset {
                            // Calculate the offset for the current page from the
                            // scroll position
                            val pageOffset =
                                this@HorizontalPager.calculateCurrentOffsetForPage(page)
                            // Then use it as a multiplier to apply an offset
                            IntOffset(
                                x = (36.dp * pageOffset).roundToPx(),
                                y = 0
                            )
                        }
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(4.dp, colors.surface)
    ) {
        Image(
            painter = rememberImagePainter(rememberRandomSampleImageUrl()),
            contentDescription = null,
            modifier = Modifier.size(72.dp),
        )
    }
}