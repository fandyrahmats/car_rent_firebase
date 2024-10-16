package com.steradiantest.car.data.repositories

import com.steradiantest.car.data.ApiServices
import com.steradiantest.car.data.model.Order

class OrdersRepository(private val apiServices: ApiServices) {

    suspend fun getOrders(): List<Order> {
        try {
            val response = apiServices.getOrders()
            if (response.isSuccessful) {
                return response.body() ?: emptyList()
            }
        } catch (e: Exception) {
            return emptyList()
        }
        return emptyList()
    }

    suspend fun addOrders(order: Order): Boolean {
        try {
            val response = apiServices.putOrder(order = order)
            if (response.isSuccessful) {
                return response.body() ?: true
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }

    suspend fun deleteOrder(order: Order): Boolean {
        try {
            val response = apiServices.deleteOrder(order = order)
            if (response.isSuccessful) {
                return response.body() ?: true
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }
}