package com.steradiantest.car.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steradiantest.car.data.model.Car
import com.steradiantest.car.data.repositories.CarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val carsRepository: CarsRepository
) : ViewModel() {
    private val _cars = MutableStateFlow<List<Car>>(emptyList())
    val cars: StateFlow<List<Car>> get()  = _cars

    init {
        getCars()
    }

    private fun getCars() {
        viewModelScope.launch(Dispatchers.IO) {
            _cars.value = carsRepository.getCars()
        }
    }
}