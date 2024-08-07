package com.msa.componentcompose.ui.component.verticalCardSlider



import android.view.Gravity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.wear.compose.material.Scaffold
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import coil.size.Scale
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.msa.componentcompose.ui.theme.ComponentComposeTheme
import kotlin.math.absoluteValue

data class SliderItem(val imageUrl: String)

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
private fun previewsSliderVertical() {
    ComponentComposeTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column {
                BuildLoginSliderVertical()
            }
        }
    }

}


// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun BuildLoginSliderVertical() {
    val pagerState = rememberPagerState(initialPage = 1)
    val sliderList: List<SliderItem> = listOf(
        SliderItem("http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png"),
        SliderItem("http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png"),
        SliderItem("http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png"),
        SliderItem("http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png")
        // افزودن آیتم‌های SliderItem بیشتر در صورت نیاز
    )

    VerticalPager(
        count = sliderList.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) { page ->
        Card(
            colors = CardDefaults.cardColors(Color.Blue),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
        ) {
            AsyncImage(
                model = Builder(LocalContext.current)
                    .data(sliderList[page].imageUrl)
                    .crossfade(true)
                    .scale(Scale.FILL)
                    .build(),
                contentDescription = null,
                modifier = Modifier.offset {
                    val pageOffset = this@VerticalPager.calculateCurrentOffsetForPage(page)
                    IntOffset(
                        x = (70.dp * pageOffset).roundToPx(),
                        y = 0,
                    )
                }
            )
        }
    }
}

