package com.steradiantest.car.ui.car_detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.steradiantest.car.R
import com.steradiantest.car.ui.main.MainViewModel
import com.steradiantest.car.ui.theme.CarRentFirebaseTheme

class CarDetailActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CarRentFirebaseTheme {
                CarDetailView()
            }
        }
    }
}