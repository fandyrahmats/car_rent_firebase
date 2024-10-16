package com.steradiantest.car.ui.car_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.steradiantest.car.data.model.Car

@Composable
fun CarDetailView(car: Car? = null) {
    var textName by remember { mutableStateOf(TextFieldValue("")) }
    var textDayRate by remember { mutableStateOf(TextFieldValue("")) }
    var textMonthRate by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding)
        ) {
            Text(text = "Car Name")
            TextField(
                value = textName,
                onValueChange = { newText ->
                    textName = newText
                }
            )
            Box(Modifier.height(16.dp))
            Text(text = "Day Rate")
            TextField(
                value = textDayRate,
                onValueChange = { newText ->
                    textDayRate = newText
                }
            )
            Box(Modifier.height(16.dp))
            Text(text = "Month Rate")
            TextField(
                value = textMonthRate,
                onValueChange = { newText ->
                    textMonthRate = newText
                }
            )
            Box(Modifier.height(16.dp))
            Button(
                onClick = {}
            ) {
                Text("Add")
            }
        }
    }
}