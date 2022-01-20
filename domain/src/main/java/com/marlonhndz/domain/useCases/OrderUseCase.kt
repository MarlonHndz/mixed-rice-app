package com.marlonhndz.domain.useCases

import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.OrderRepository

class OrderUseCase(
    private val orderRepository: OrderRepository
) {
    suspend fun addProductToOrder(product: Product) {
        orderRepository.addProductToOrder(product)
    }

    suspend fun getOrders(): List<Order> {
        return orderRepository.getOrders()
    }

    suspend fun clearOrder() {
        return orderRepository.clearOrder()
    }
}
