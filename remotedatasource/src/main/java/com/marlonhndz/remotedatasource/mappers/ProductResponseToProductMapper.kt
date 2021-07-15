package com.marlonhndz.remotedatasource.mappers

import com.marlonhndz.domain.models.Product
import com.marlonhndz.remotedatasource.models.ProductResponse

class ProductResponseToProductMapper {

    operator fun invoke(productResponse: ProductResponse): List<Product> {
        val productList = mutableListOf<Product>()
        productResponse.data.product.map { product ->
            val newProduct = Product(
                name = product.name,
                description = product.description,
                imageURL = product.imageURL
            )
            productList.add(newProduct)
        }
        return productList
    }
}
