
package com.msa.componentcompose.ui.component.expandable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.theme.ComponentComposeTheme



@ExperimentalMaterialApi
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    padding: Dp = 12.dp,
    painter: Painter = painterResource(id = R.drawable.sun),
    content: // Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable ColumnScope.() -> Unit,
){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(18.dp))
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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
            if (expandedState) {
                content()
            }
        }
    }
}


@ExperimentalMaterialApi
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    painter: Painter = painterResource(id = R.drawable.sun),
    padding: Dp = 12.dp
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(18.dp))
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(40.dp),
                    painter = painter,
                    contentDescription = "logo")
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
            if (expandedState) {
                Text(
                    text = description,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@ExperimentalMaterialApi
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
@Preview
fun ExpandableCardPreview() {
    ComponentComposeTheme {
        Column(
            modifier = Modifier
            .fillMaxSize()
                .background(Color.White)
        ){
            ExpandableCard(
                title = "My Title",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat" +
                        "dfgdfgddddddddddddddddddddddddddddddddddddddddddddddddsfsdf" +
                        "dsfdsffsdfsdfsdfsdfsdfsdfdsfdsfsdfsdfsdfdsfsdfsdfdsfsd" +
                        "sdfsdfsfdsfdsfsdfsdfsdfsdxcvcxvcxvcxvcxfsdfsdfsdfsdfsdfsdfsdfds" +
                        "dsfsdfdsfsdfsdfxcvxcvcxvsdfsdfsdfdsfsdfdsfdsfsd" +
                        "hjjhgjg" +
                        "ghjhgjghjghjghghghghghghghghghghghghghghghghghghghghghghghghghghghghghghghghghghj" +
                        "ghjghjghjghjhdfgfdgfdgdfgdfgdfgdfgdfgdfgdfgdfgdfgdffdgfdg" +
                        "fdgfdgfdgdfgdfgdfgdfgdfgdf."
            )
            ExpandableCard(
                title = "My Title2",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )

            ExpandableCard(
                title = "My Title2",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )

            ExpandableCard(
                title = "My Title2",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )
            ExpandableCard(
                title = "My Title2",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                        "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                        "ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )
        }
    }


}
