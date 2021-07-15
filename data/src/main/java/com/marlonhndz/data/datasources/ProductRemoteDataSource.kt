package com.marlonhndz.data.datasources

import com.marlonhndz.domain.models.Product

interface ProductRemoteDataSource {
    suspend fun getProductList(): List<Product>
}
