@file:OptIn(ExperimentalWearMaterialApi::class)

package com.msa.componentcompose.ui.component.switchC

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.theme.ComponentComposeTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomSwitch(
    height: Dp,
    width: Dp,
    circleButtonPadding: Dp,
    outerBackgroundOnResource: Int? = null, // kmm code int -> DrawableResource
    outerBackgroundOffResource: Int? = null, // kmm code int -> DrawableResource
    circleBackgroundOnResource: Int,
    circleBackgroundOffResource: Int,
    borderColor: Color = Color.DarkGray,
    onBackgroundColor: Color = Color.Green,
    offBackgroundColor: Color = Color.Red,
    stateOn: Int,
    stateOff: Int,
    initialValue: Int,
    onCheckedChanged: (checked: Boolean) -> Unit
) {
    val swipeableState = rememberSwipeableState(
        initialValue = initialValue,
        confirmStateChange = { newState ->
            if (newState == stateOff) {
                onCheckedChanged(false)
            } else {
                onCheckedChanged(true)
            }
            true
        }
    )

    val sizePx = with(LocalDensity.current) { (width - height).toPx() }
    val anchors = mapOf(0f to stateOff, sizePx to stateOn) // Maps anchor points (in px) to states

    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .height(height)
            .width(width)
            .clip(RoundedCornerShape(height))
            .border(1.dp, borderColor, CircleShape)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.Transparent)
            .then(
                if (swipeableState.currentValue == stateOff) {
                    if (outerBackgroundOffResource != null) {
                        Modifier.paint(
                            painterResource(outerBackgroundOffResource),
                            contentScale = ContentScale.FillBounds
                        )
                    } else {
                        Modifier.background(offBackgroundColor)
                    }
                } else {
                    if (outerBackgroundOnResource != null) {
                        Modifier.paint(
                            painterResource(outerBackgroundOnResource),
                            contentScale = ContentScale.FillBounds
                        )
                    } else {
                        Modifier.background(onBackgroundColor)
                    }
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(height)
                .padding(circleButtonPadding)
                .clip(CircleShape)
                .then(
                    if (swipeableState.currentValue == stateOff) Modifier.paint(
                        painterResource(circleBackgroundOffResource),
                        contentScale = ContentScale.FillBounds
                    ) else Modifier.paint(
                        painterResource(circleBackgroundOnResource),
                        contentScale = ContentScale.FillBounds
                    )
                )
                .clickable {
                    scope.launch {
                        if (swipeableState.currentValue == stateOff) {
                            swipeableState.animateTo(stateOn)
                        } else {
                            swipeableState.animateTo(stateOff)
                        }
                    }
                }
        )
    }
}

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomSwitchPreviewOff() {
    ComponentComposeTheme {
        CustomSwitch(
            height = 70.dp,
            width = 140.dp,
            circleButtonPadding = 4.dp,
            outerBackgroundOnResource = R.drawable.switch_body_night,
            outerBackgroundOffResource = R.drawable.switch_body_day,
            circleBackgroundOnResource = R.drawable.switch_btn_moon,
            circleBackgroundOffResource = R.drawable.switch_btn_sun,
            stateOn = 1,
            stateOff = 0,
            initialValue = 0,
            onCheckedChanged = {}
        )
    }
}

@Preview
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun CustomSwitchPreviewOn() {
    ComponentComposeTheme {
        Column(modifier = Modifier.size(190.dp)){
            CustomSwitch(
                height = 70.dp,
                width = 140.dp,
                circleButtonPadding = 4.dp,
                outerBackgroundOnResource = R.drawable.switch_body_night,
                outerBackgroundOffResource = R.drawable.switch_body_day,
                circleBackgroundOnResource = R.drawable.switch_btn_moon,
                circleBackgroundOffResource = R.drawable.switch_btn_sun,
                stateOn = 1,
                stateOff = 0,
                initialValue = 1,
                onCheckedChanged = {}
            )
            CustomSwitch(
                height = 70.dp,
                width = 140.dp,
                circleButtonPadding = 4.dp,
                outerBackgroundOnResource = null,  // No resource provided
                outerBackgroundOffResource = null, // No resource provided
                circleBackgroundOnResource = R.drawable.switch_btn_moon,
                circleBackgroundOffResource = R.drawable.switch_btn_sun,
                stateOn = 1,
                stateOff = 0,
                initialValue = 1,
                onCheckedChanged = {}
            )
        }
    }
}
