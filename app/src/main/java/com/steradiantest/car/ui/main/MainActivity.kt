package com.steradiantest.car.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.steradiantest.car.data.model.Car
import com.steradiantest.car.ui.theme.CarRentFirebaseTheme
import com.steradiantest.car.utils.toRupiah
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarRentFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    val cars by viewModel.cars.collectAsState()
                    Column {
                        cars.forEach {
                            CarItem(it)
                        }
                        FloatingActionButton(
                            onClick = {

                            }
                        ) {
                            Text(text = "Add Car")
                        }
                    }

                }
            }
        }
    }

}


@Composable
fun CarItem(car: Car) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(car.image)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(50.dp),
            contentDescription = ""
        )
        Box(
            modifier = Modifier.width(8.dp)
        )
        Column {
            Text(
                text = car.name,
                style = TextStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize)
            )
            Box(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = car.dayRate.toString().toRupiah(),
                style = TextStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize)
            )
            Box(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = car.dayRate.toString().toRupiah(),
                style = TextStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarRentFirebaseTheme {

    }
}