package com.marlonhndz.localdatasource.mappers

import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.models.ProductLocal

class ProductLocalToProductMapper {

    operator fun invoke(listProductLocal: List<ProductLocal>): List<Product> {
        val productList = mutableListOf<Product>()
        listProductLocal.map { productLocal ->
            productList.add(mapper(productLocal))
        }
        return productList
    }

    operator fun invoke(productLocal: ProductLocal) = mapper(productLocal)

    private fun mapper(productLocal: ProductLocal) = Product(
        name = productLocal.name,
        description = productLocal.description,
        imageURL = productLocal.imageURL
    )
}
