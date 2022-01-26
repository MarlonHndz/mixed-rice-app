package com.marlonhndz.data.datasources.localdatasource

import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product

interface OrderLocalDataSource {
    suspend fun addProductToOrder(product: Product, productQuantity: Int)
    suspend fun getOrders(): List<Order>
    suspend fun clearOrder()
}
