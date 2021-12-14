package com.marlonhndz.domain.repositories

import com.marlonhndz.domain.models.Product

interface ProductRepository {
    suspend fun getProductsList(): List<Product>
}
