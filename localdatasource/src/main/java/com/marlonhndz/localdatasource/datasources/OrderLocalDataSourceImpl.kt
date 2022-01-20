package com.marlonhndz.localdatasource.datasources

import com.marlonhndz.data.datasources.localdatasource.OrderLocalDataSource
import com.marlonhndz.data.mappers.OrderLocalToOrderMapper
import com.marlonhndz.data.mappers.ProductToOrderLocalMapper
import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.AppDatabase

class OrderLocalDataSourceImpl(
    private val appDatabase: AppDatabase,
    private val productToOrderLocalMapper: ProductToOrderLocalMapper,
    private val orderLocalToOrderMapper: OrderLocalToOrderMapper
) : OrderLocalDataSource {

    override suspend fun addProductToOrder(product: Product) {
        appDatabase.orderDao().insert(productToOrderLocalMapper(product))
    }

    override suspend fun getOrders(): List<Order> {
        val orders = appDatabase.orderDao().getAll()
        return orders.map {
            val orderedProduct = appDatabase.productDao().getProductByID(it.productId)
            val orderedAmount = appDatabase.amountDao().getAmountByID(it.amountId)
            orderLocalToOrderMapper(orderedProduct, orderedAmount)
        }
    }

    override suspend fun clearOrder() {
        appDatabase.orderDao().clearTable()
    }
}
