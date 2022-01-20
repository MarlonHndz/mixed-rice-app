package com.marlonhndz.data.repositories

import com.marlonhndz.data.datasources.localdatasource.OrderLocalDataSource
import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.OrderRepository

class OrderRepositoryImpl(
    private val orderLocalDataSource: OrderLocalDataSource
) : OrderRepository {

    override suspend fun addProductToOrder(product: Product) {
        orderLocalDataSource.addProductToOrder(product)
    }

    override suspend fun getOrders(): List<Order> {
        return orderLocalDataSource.getOrders()
    }

    override suspend fun clearOrder() {
        orderLocalDataSource.clearOrder()
    }
}
