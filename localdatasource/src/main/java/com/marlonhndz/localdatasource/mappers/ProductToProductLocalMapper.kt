package com.marlonhndz.localdatasource.mappers

import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.models.ProductLocal

class ProductToProductLocalMapper {

    operator fun invoke(listProduct: List<Product>): List<ProductLocal> {
        val productLocalList = mutableListOf<ProductLocal>()
        listProduct.map { product ->
            productLocalList.add(mapper(product))
        }
        return productLocalList
    }

    operator fun invoke(product: Product) = mapper(product)

    private fun mapper(product: Product) = ProductLocal(
        name = product.name,
        description = product.description,
        imageURL = product.imageURL
    )
}
