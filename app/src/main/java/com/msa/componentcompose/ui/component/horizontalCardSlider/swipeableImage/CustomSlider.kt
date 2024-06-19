package com.msa.componentcompose.ui.component.horizontalCardSlider.swipeableImage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable

import android.content.ContentValues
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.msa.componentcompose.R
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun CustomSlider(
//    modifier: Modifier = Modifier,
//    sliderList: MutableList<String>,
//    backwardIcon: ImageVector = Icons.Default.KeyboardArrowLeft,
//    forwardIcon: ImageVector = Icons.Default.KeyboardArrowRight,
//    dotsActiveColor: Color = Color.DarkGray,
//    dotsInActiveColor: Color = Color.LightGray,
//    dotsSize: Dp = 10.dp,
//    pagerPaddingValues: PaddingValues = PaddingValues(horizontal = 65.dp),
//    imageCornerRadius: Dp = 16.dp,
//    imageHeight: Dp = 250.dp,
//) {
//
//    val pagerState = rememberPagerState(initialPage = 1, pageCount = { sliderList.size })
//    val scope = rememberCoroutineScope()
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
//    ) {
//        Row(
//            modifier = modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//        ) {
//
//
//            HorizontalPager(
//                state = pagerState,
//                contentPadding = pagerPaddingValues,
//                modifier = modifier.weight(1f)
//            ) { page ->
//                val pageOffset =
//                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
//
//                val scaleFactor = 0.75f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)
//
//
//                Box(modifier = modifier
//                    .graphicsLayer {
//                        scaleX = scaleFactor
//                        scaleY = scaleFactor
//                    }
//                    .alpha(
//                        scaleFactor.coerceIn(0f, 1f)
//                    )
//                    .padding(10.dp)
//                    .clip(RoundedCornerShape(imageCornerRadius))) {
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current).scale(Scale.FILL)
//                            .crossfade(true).data(sliderList[page]).build(),
//                        contentDescription = "Image",
//                        contentScale = ContentScale.Crop,
//                        placeholder = painterResource(id = R.drawable.switch_body_night),
//                        modifier = modifier.height(imageHeight)
////                            .alpha(if (pagerState.currentPage == page) 1f else 0.5f)
//                    )
//                }
//            }
//
//        }
//    }
//}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomSlider(
    modifier: Modifier = Modifier,
    sliderList: MutableList<String>,
    backwardIcon: ImageVector = Icons.Default.KeyboardArrowLeft,
    forwardIcon: ImageVector = Icons.Default.KeyboardArrowRight,
    dotsActiveColor: Color = Color.DarkGray,
    dotsInActiveColor: Color = Color.LightGray,
    dotsSize: Dp = 10.dp,
    pagerPaddingValues: PaddingValues = PaddingValues(horizontal = 65.dp),
    imageCornerRadius: Dp = 16.dp,
    imageHeight: Dp = 250.dp,
) {


    val pagerState = rememberPagerState(initialPage = 0, pageCount = { sliderList.size })
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            IconButton(enabled = pagerState.canScrollBackward, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            }) {
                Icon(imageVector = backwardIcon, contentDescription = "back")
            }
            HorizontalPager(
                state = pagerState,
                contentPadding = pagerPaddingValues,
                modifier = modifier.weight(1f)
            ) { page ->

                val pageOffset =
                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

                val scaleFactor = 0.75f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)


                Box(modifier = modifier
                    .graphicsLayer {
                        scaleX = scaleFactor
                        scaleY = scaleFactor
                    }
                    .alpha(
                        scaleFactor.coerceIn(0f, 1f)
                    )
                    .padding(10.dp)
                    .clip(RoundedCornerShape(imageCornerRadius))) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current).scale(Scale.FILL)
                            .crossfade(true).data(sliderList[page]).build(),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = R.drawable.switch_body_night),
                        modifier = modifier.height(imageHeight)
                           .alpha(if (pagerState.currentPage == page) 1f else 0.5f)
                    )
                }

            }
            IconButton(enabled = pagerState.currentPage != sliderList.size - 1, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }) {
                Icon(imageVector = forwardIcon, contentDescription = "forward")
            }
        }
        Row(
            modifier
                .height(50.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            repeat(sliderList.size) {
                val color = if (pagerState.currentPage == it) dotsActiveColor else dotsInActiveColor
                Box(modifier = modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .size(dotsSize)
                    .background(color)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(it)
                        }
                    })
            }
        }
    }
}
@Preview
@PreviewScreenSizes
@Composable
private fun CustomSliderPreciew() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        val sliderList = remember {
            mutableListOf(
                "https://www.gstatic.com/webp/gallery/1.webp",
                "https://www.gstatic.com/webp/gallery/2.webp",
                "https://www.gstatic.com/webp/gallery/3.webp",
                "https://www.gstatic.com/webp/gallery/4.webp",
                "https://www.gstatic.com/webp/gallery/5.webp",
            )
        }
        CustomSlider(sliderList = sliderList)
    }
}
