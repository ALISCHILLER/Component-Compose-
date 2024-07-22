package com.msa.componentcompose.ui.Screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.component.expandable.ExpandableUnderLineCard
import com.msa.componentcompose.ui.component.switchC.CustomSwitch

// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
@Preview
fun InformationAccountScreen(modifier: Modifier = Modifier) {

    Column(
        modifier=modifier.fillMaxWidth()
    ){
        ExpandableUnderLineCard(
            title = "مدل خودرو",
            painter = painterResource(id = R.drawable.ic_car)
        ) {
            CarModelCard()
        }
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "تم برنامه",
            painter = painterResource(id = R.drawable.ic_moon)
        ){
            CustomSwitch(
                height = 40.dp,
                width = 100.dp,
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
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "ورود از طریق اثر انگشت",
            painter = painterResource(id = R.drawable.ic_fingercricle)
        ){
            CustomSwitch(
                height = 40.dp,
                width = 100.dp,
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