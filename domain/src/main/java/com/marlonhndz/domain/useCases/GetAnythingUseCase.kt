package com.marlonhndz.domain.useCases

import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.repositories.ProductRepository

class GetProductUseCase (
    private val productRepository: ProductRepository
) {
    suspend fun getProduct(): List<Product> {
        return productRepository.getProduct()
    }
}
