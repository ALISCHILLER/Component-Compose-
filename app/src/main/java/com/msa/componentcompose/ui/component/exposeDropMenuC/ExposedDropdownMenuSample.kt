package com.msa.componentcompose.ui.component.exposeDropMenuC

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.componentcompose.ui.component.editeText.CustomBasicTextField
import com.msa.componentcompose.ui.theme.barcolorlight2
import com.msa.componentcompose.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun <T> ExposedDropdownMenuSample(
    listOptions: List<T>,
    modifier: Modifier = Modifier,
    initiallySelectedOption: T? = null,
    onOptionSelected: (T) -> Unit
) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(initiallySelectedOption ?: listOptions.first()) }


        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = modifier
        ) {
            CustomBasicTextField(
                value =  selectedOption.toString(),
                onValueChange = {  },
                borderColor = Color.Black,
                backgroundColor = barcolorlight2,
                corner = RoundedCornerShape(9.dp),
                textColor = Color.White,
                leadingIcon = Icons.Filled.ArrowDropDown,
                modifier = Modifier.menuAnchor(),
                enabled = false,
                leadingColor = white
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOptions.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.toString()) },
                        onClick = {
                            selectedOption = item
                            expanded = false
                            onOptionSelected(item)
                            Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }

}

@Preview(showBackground = true)
// Create Ali Soleymani
//-------------------- Create Ali Soleimani--------------------//
//-------------------- Create Ali Soleimani--------------------//
@Composable
fun ExposedDropdownMenuSamplePreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ExposedDropdownMenuSample(
                modifier = Modifier
                    .padding(10.dp)
                    .width(90.dp)
                    .height(50.dp)
                    .background(Color.Yellow)
                ,
                listOptions = listOf("الف", "Cappuccino", "Espresso", "Latte", "Mocha"),
                onOptionSelected = { selectedOption ->
                    // Handle option selected
                }
            )
        }
    }
}
