package com.steradiantest.car.data.model

data class Order(
    val id: String,
    val carId: String,
    val orderDate: String,
    val pickupDate: String,
    val dropOffDate: String,
    val pickupLocation: String,
    val dropOffLocation: String,
)