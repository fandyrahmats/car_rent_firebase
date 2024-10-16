package com.steradiantest.car.data.repositories

import android.util.Log
import com.steradiantest.car.data.ApiServices
import com.steradiantest.car.data.model.Car

class CarsRepository(private val apiServices: ApiServices) {
    suspend fun getCars(): List<Car> {
        try {
            val response = apiServices.getCars()
            if (response.isSuccessful) {
                val carList: List<Car> = response.body() ?: emptyList()
                return carList
            }
        } catch (e: Exception) {
            return emptyList()
        }
        return emptyList()
    }

    suspend fun deleteCar(car: Car): Boolean {
        try {
            val response = apiServices.deleteCar(car = car)
            if (response.isSuccessful) {
                return response.body() ?: true
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }

    suspend fun addCar(car: Car): Boolean {
        try {
            val response = apiServices.putCar(car = car)
            if (response.isSuccessful) {
                return response.body() ?: true
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }
}