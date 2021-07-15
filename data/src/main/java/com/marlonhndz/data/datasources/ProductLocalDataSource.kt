package com.marlonhndz.data.datasources

import com.marlonhndz.domain.models.Product

interface ProductLocalDataSource {
    suspend fun getProductList(): List<Product>
    suspend fun insertProductList(listProduct: List<Product>)
}
