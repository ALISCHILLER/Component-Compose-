@file:OptIn(ExperimentalMaterialApi::class)

package com.msa.componentcompose.ui.Screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.component.expandable.ExpandableCard
import com.msa.componentcompose.ui.component.expandable.ExpandableUnderLineCard

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxSize(),

    ){
        Surface(
            modifier = Modifier
                .size(154.dp)
                .padding(5.dp),
            shape = CircleShape,
            border = BorderStroke(0.5.dp, Color.LightGray),
            tonalElevation = 4.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "profile image",
                modifier = modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )

        }
        textShow(text = "کد پرسنلی: ۵۰۰۰۹۹۰")
        textShow(text = "نانا قالبی ")
        textShow(text = "کارشناس نرم افزار ")

        ExpandableUnderLineCard(
            title = "اطلاعات حساب کاربری",
            painter = painterResource(id = R.drawable.ic_profile)
        ) {
            InformationAccountScreen()
        }


    }
}


@Composable
fun textShow(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 3.dp),
        text = text,
        )
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            ProfileScreen()
        }
    }

}