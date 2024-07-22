package com.msa.componentcompose.ui.component.verticalCardSlider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.msa.componentcompose.ui.theme.ComponentComposeTheme
import kotlin.math.abs

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun Carousel(
    count: Int,
    parentModifier: Modifier = Modifier
        .fillMaxWidth()
        .height(540.dp),
    contentWidth: Dp,
    contentHeight: Dp,
    content: // Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable (modifier: Modifier, index: Int) -> Unit
) {
    val listState = rememberLazyListState(Int.MAX_VALUE / 2)

    BoxWithConstraints(
        modifier = parentModifier
    ) {
        val halfRowWidth = constraints.maxWidth / 2

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 10.dp),
            verticalArrangement = Arrangement.spacedBy(-contentHeight / 2),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = Int.MAX_VALUE,
                itemContent = { globalIndex ->
                    val scale by remember {
                        derivedStateOf {
                            val currentItem = listState.layoutInfo.visibleItemsInfo.firstOrNull { it.index == globalIndex } ?: return@derivedStateOf 0.85f

                            (1f - minOf(1f, abs(currentItem.offset + (currentItem.size / 2) - halfRowWidth).toFloat() / halfRowWidth) * 0.25f)
                        }
                    }

                    content(
                        index = globalIndex % count,
                        modifier = Modifier
                            .width(contentWidth)
                            .height(contentHeight)
                            .scale(scale)
                            .zIndex(scale * 10)
                    )
                }
            )
        }
    }
}

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun MyScreen() {
    val cards = listOf(
        CardItem("Card 1", "Description for Card 1", "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner2.png"),
        CardItem("Card 2", "Description for Card 2", "http://5.160.125.98:8080/Content/Orginal2/CategoryIcon/spaghettired.png"),
        CardItem("Card 3", "Description for Card 3", "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png"),
        CardItem("Card 4", "Description for Card 3", "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png"),
        CardItem("Card 5", "Description for Card 3", "http://5.160.125.98:8080/Content/Orginal2/Banner/Banner1.png"),
        // Add more cards as needed
    )
    ComponentComposeTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ){
            val p = it
            Carousel(
                count = cards.size,
                parentModifier = Modifier
                    .fillMaxWidth()
                    .height(540.dp),
                contentWidth = 400.dp, // Adjust as needed
                contentHeight = 200.dp, // Adjust as needed
            ) { modifier, index ->
                CardItem(
                    card = cards[index],
                    modifier = modifier
                )
            }

        }
    }


}