@file:Suppress("DEPRECATION")
package com.msa.componentcompose.ui.component.pager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme.colors
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

/**
 * Simple pager item which displays an image
 */
@OptIn(ExperimentalCoilApi::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
internal fun PagerSampleItem(
    page: Int,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        // Our page content, displaying a random image
        Image(
            painter = rememberImagePainter(
                data = rememberRandomSampleImageUrl(width = 600),
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
        )

        // Displays the page index
//        Text(
//            text = page.toString(),
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .padding(16.dp)
//                .background(colors.surface, RoundedCornerShape(4.dp))
//                .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
//                .padding(8.dp)
//                .wrapContentSize(Alignment.Center)
//        )
    }
}
