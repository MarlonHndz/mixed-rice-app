package com.marlonhndz.data.repositories

import com.marlonhndz.data.datasources.ProductLocalDataSource
import com.marlonhndz.data.datasources.ProductRemoteDataSource
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val remoteDataSource: ProductRemoteDataSource,
    private val localDataSource: ProductLocalDataSource
) : ProductRepository {

    override suspend fun getProduct(): List<Product> {
        val productResponse = remoteDataSource.getProductList()
        localDataSource.insertProductList(productResponse)
        return localDataSource.getProductList()
    }
}
