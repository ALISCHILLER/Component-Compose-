package com.msa.componentcompose.ui.Screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.R
import com.msa.componentcompose.ui.component.editeText.CustomBasicTextField
import com.msa.componentcompose.ui.component.editeText.OutTextFieldSample
import com.msa.componentcompose.ui.component.editeText.RoundedIconTextField
import com.msa.componentcompose.ui.component.exposeDropMenuC.ExposedDropdownMenuSample
import com.msa.componentcompose.ui.theme.ComponentComposeTheme
import com.msa.componentcompose.ui.theme.OrangeStatus
import com.msa.componentcompose.ui.theme.barcolorlight
import com.msa.componentcompose.ui.theme.barcolorlight2
import com.msa.componentcompose.ui.theme.tagcar
import com.msa.componentcompose.ui.theme.white

@Composable
fun CarModelCard(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            TagCar()
            var nameCar by remember { mutableStateOf("") }
            RoundedIconTextField(
                value = nameCar,
                onValueChange = { nameCar = it },
                label = "نام خودرو",
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                corner=RoundedCornerShape(9.dp),
                labelColor = OrangeStatus
            )

        }
    }
}

@Composable
fun TagCar(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf("") }
    val itemHeight = 80.dp // ارتفاع یکسان برای همه اجزا

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.7f)
                .height(itemHeight)
                .background(barcolorlight)
                .padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ایران",
            )

            OutTextFieldSample(
                modifier = Modifier.fillMaxWidth(),
                value = number,
                onValueChange = { number = it },
                corner = RoundedCornerShape(12.dp),
                keyboardType = KeyboardType.Number,
                maxLength = 2,
                textSize = 9
            )
        }

        Spacer(modifier = Modifier.width(2.dp))

        Row(
            modifier = Modifier
                .weight(2f)
                .height(itemHeight)
                .background(barcolorlight)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutTextFieldSample(
                modifier = Modifier
                    .weight(1.5f)
                    .padding(horizontal = 3.dp),
                value = number,
                onValueChange = { number = it },
                corner = RoundedCornerShape(12.dp),
                keyboardType = KeyboardType.Number,
                maxLength = 3
            )

            ExposedDropdownMenuSample(
                modifier = Modifier
                    .weight(2f)
                    .padding(3.dp)
                    .background(barcolorlight2),
                listOptions = listOf("الف", "ب", "پ", "ت", "ث"),
                onOptionSelected = { selectedOption ->
                    // Handle option selected
                }
            )

            val textState = remember { mutableStateOf("") }
            CustomBasicTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                borderColor = Color.Black,
                modifier = Modifier
                    .weight(1f),
                backgroundColor = barcolorlight2,
                corner = RoundedCornerShape(12.dp),
                textColor = Color.White,
                keyboardType = KeyboardType.Number
            )
        }

        Card(
            modifier = Modifier
                .weight(0.5f)
                .height(itemHeight)
                .background(tagcar, shape = RoundedCornerShape(
                    topEnd = 10.dp,
                    bottomEnd = 10.dp,
                ))
                .padding(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = tagcar
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_iranflag),
                    contentDescription = "iranflag"
                )
                Text(
                    text = "I.R.",
                    color = white
                )
                Text(
                    text = "IRAN",
                    color = white
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CarModelCardPreview() {
    ComponentComposeTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            CarModelCard()
        }
    }
}
