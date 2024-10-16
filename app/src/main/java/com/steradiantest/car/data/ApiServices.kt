package com.steradiantest.car.data

import com.steradiantest.car.data.model.Car
import com.steradiantest.car.data.model.Order
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT


interface ApiServices {
    @GET("orders")
    suspend fun getOrders(): Response<List<Order>>

    @PUT("orders")
    suspend fun putOrder(order: Order): Response<Boolean>

    @DELETE("orders")
    suspend fun deleteOrder(order: Order): Response<Boolean>

    @GET("cars")
    suspend fun getCars(): Response<List<Car>>

    @PUT("cars")
    suspend fun putCar(car: Car): Response<Boolean>

    @DELETE("cars")
    suspend fun deleteCar(car: Car): Response<Boolean>
}