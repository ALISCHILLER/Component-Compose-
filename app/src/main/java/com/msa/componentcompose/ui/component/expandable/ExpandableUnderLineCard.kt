package com.msa.componentcompose.ui.component.expandable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.theme.background75
import com.msa.componentcompose.ui.theme.barcolorlight2

@Composable
fun ExpandableUnderLineCard(
    modifier: Modifier = Modifier,
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    padding: Dp = 12.dp,
    painter: Painter = painterResource(id = R.drawable.sun),
    content: @Composable ColumnScope.() -> Unit,
) {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {


        Column(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable {
                    expandedState = !expandedState
                }
            ,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(40.dp),
                    painter = painter,
                    contentDescription = "logo"
                )
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            HorizontalDivider(color = barcolorlight2, thickness = 2.dp)

            if (expandedState) {
                content()
            }
        }
    }
}

@Preview
@Composable
private fun ExpandableUnderLineCardPreview() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
            .background(background75)
    ) {
        ExpandableUnderLineCard(
            title = "My Title",
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                color = Color.Red
            ){

            }
        }
    }
}