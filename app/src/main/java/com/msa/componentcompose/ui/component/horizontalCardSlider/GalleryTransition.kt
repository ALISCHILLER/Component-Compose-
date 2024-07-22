@file:OptIn(ExperimentalFoundationApi::class)

package com.msa.componentcompose.ui.component.horizontalCardSlider

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.msa.componentcompose.R

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun GalleryTransition(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val images = remember {
        mutableStateListOf(
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png",
            "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png",
        )
    }
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { images.size })
    val matrix = remember {
        ColorMatrix()
    }
    Scaffold(modifier = modifier.padding(vertical = 48.dp)) {
        HorizontalPager(
            state = pagerState,
        ) { index ->
            Log.d(TAG, "GalleryTransition: ${pagerState.currentPageOffsetFraction}")
            val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                animationSpec = tween(durationMillis = 300)
            )

            LaunchedEffect(key1 = imageSize) {
                if (pageOffset != 0.0f) {
                    matrix.setToSaturation(0f)
                } else {
                    matrix.setToSaturation(1f)
                }
            }
            AsyncImage(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    },
                model = images[index],
                contentDescription = "Pager Image",
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.switch_body_day),
                colorFilter = ColorFilter.colorMatrix(matrix),

            )

        }


    }
}