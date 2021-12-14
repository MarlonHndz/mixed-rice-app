package com.marlonhndz.domain.useCases

import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.ProductRepository

class ProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun getProducts(): List<Product> {
        return productRepository.getProductsList()
    }
}
