package com.marlonhndz.domain.repositories

import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product

interface OrderRepository {
    suspend fun addProductToOrder(product: Product, productQuantity: Int)
    suspend fun getOrders(): List<Order>
    suspend fun clearOrder()
    suspend fun updateOrder(order: Order)
}
