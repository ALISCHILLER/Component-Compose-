@file:OptIn(ExperimentalMaterial3Api::class)

package com.msa.componentcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.ui.Screen.profile.CarModelCard
import com.msa.componentcompose.ui.Screen.profile.InformationAccountScreen
import com.msa.componentcompose.ui.Screen.profile.ProfileScreen
import com.msa.componentcompose.ui.component.animateC.App
import com.msa.componentcompose.ui.component.verticalCardSlider.my.VerticalSlider
import com.msa.componentcompose.ui.theme.ComponentComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            ComponentComposeTheme {
//                Scaffold(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.White)
//                ) { innerPadding ->
//                    VerticalSlider(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                            .fillMaxWidth()
//                            .height(200.dp)
//                    )
//                }
//            }
            ProfileScreen()
        }
    }
}

//-------------------- Create Ali Soleimani--------------------//
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun GreetingPreview() {
    ComponentComposeTheme {
        Greeting("Android")
    }
}