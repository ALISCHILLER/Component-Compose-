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

        }
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "تم برنامه",
            painter = painterResource(id = R.drawable.ic_moon)
        )
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "ورود از طریق اثر انگشت",
            painter = painterResource(id = R.drawable.ic_fingercricle)
        )

    }


}