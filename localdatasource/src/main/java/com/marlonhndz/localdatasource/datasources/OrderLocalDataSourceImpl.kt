package com.marlonhndz.localdatasource.datasources

import com.marlonhndz.data.datasources.localdatasource.OrderLocalDataSource
import com.marlonhndz.data.mappers.OrderLocalToOrderMapper
import com.marlonhndz.data.mappers.OrderToOrderLocalMapper
import com.marlonhndz.data.mappers.ProductToOrderLocalMapper
import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.AppDatabase

class OrderLocalDataSourceImpl(
    private val appDatabase: AppDatabase,
    private val productToOrderLocalMapper: ProductToOrderLocalMapper,
    private val orderLocalToOrderMapper: OrderLocalToOrderMapper,
    private val orderToOrderLocalMapper: OrderToOrderLocalMapper
) : OrderLocalDataSource {

    override suspend fun addProductToOrder(product: Product, productQuantity: Int) {
        appDatabase.orderDao().insert(productToOrderLocalMapper(product, productQuantity))
    }

    override suspend fun getOrders(): List<Order> {
        val ordersLocal = appDatabase.orderDao().getAll()
        return ordersLocal.map {
            val orderedProduct = appDatabase.productDao().getProductByID(it.productId)
            val orderedAmount = appDatabase.amountDao().getAmountByID(it.amountId)
            orderLocalToOrderMapper(it.orderId, orderedProduct, orderedAmount, it.productQuantity)
        }
    }

    override suspend fun clearOrderList() {
        appDatabase.orderDao().clearTable()
    }

    override suspend fun updateOrder(order: Order) {
        appDatabase.orderDao().updateOrder(orderToOrderLocalMapper(order))
    }

    override suspend fun deleteOrderFromList(order: Order) {
        appDatabase.orderDao().delete(orderToOrderLocalMapper(order))
    }
}
