package com.marlonhndz.data.repositories

import com.marlonhndz.data.datasources.localdatasource.ProductLocalDataSource
import com.marlonhndz.data.datasources.remotedatasource.MenuRemoteDataSource
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val menuRemoteDataSource: MenuRemoteDataSource,
    private val productLocalDataSource: ProductLocalDataSource
) : ProductRepository {

    override suspend fun getProductsList(): List<Product> {
        val menuResponse = menuRemoteDataSource.getMenuResponse()
        productLocalDataSource.insertMenu(menuResponse)
        return productLocalDataSource.getProductList()
    }
}
