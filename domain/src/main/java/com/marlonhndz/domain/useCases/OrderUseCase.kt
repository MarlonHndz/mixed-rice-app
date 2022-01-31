package com.marlonhndz.domain.useCases

import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.OrderRepository

class OrderUseCase(
    private val orderRepository: OrderRepository
) {
    suspend fun addProductToOrder(product: Product, productQuantity: Int) {
        orderRepository.addProductToOrder(product, productQuantity)
    }

    suspend fun getOrders(): List<Order> {
        return orderRepository.getOrders()
    }

    suspend fun clearOrderList() {
        orderRepository.clearOrderList()
    }

    suspend fun updateOrder(order: Order) {
        orderRepository.updateOrder(order)
    }

    suspend fun deleteOrderFromList(order: Order) {
        orderRepository.deleteOrderFromList(order)
    }
}
