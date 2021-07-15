package com.marlonhndz.localdatasource.datasources

import com.marlonhndz.data.datasources.ProductLocalDataSource
import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.AppDatabase
import com.marlonhndz.localdatasource.mappers.ProductLocalToProductMapper
import com.marlonhndz.localdatasource.mappers.ProductToProductLocalMapper

class ProductLocalDataSourceImpl(
    private val appDatabase: AppDatabase,
    private val productLocalToProductMapper: ProductLocalToProductMapper,
    private val productToProductLocalMapper: ProductToProductLocalMapper
) : ProductLocalDataSource {

    override suspend fun getProductList() =
        productLocalToProductMapper(appDatabase.productDao().getAll())

    override suspend fun insertProductList(listProduct: List<Product>) {
        appDatabase.productDao().insertAll(productToProductLocalMapper(listProduct))
    }
}
