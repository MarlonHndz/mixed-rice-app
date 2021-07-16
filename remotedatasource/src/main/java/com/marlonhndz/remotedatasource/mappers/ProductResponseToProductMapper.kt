package com.marlonhndz.remotedatasource.mappers

import com.marlonhndz.domain.models.Amount
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.models.ProductType
import com.marlonhndz.remotedatasource.models.ProductResponse

class ProductResponseToProductMapper {

    operator fun invoke(productResponse: ProductResponse): List<Product> {
        val productList = mutableListOf<Product>()
        productResponse.data.products.map { product ->
            val newProduct = Product(
                id = product.id,
                name = product.name,
                description = product.description,
                imageURL = product.image,
                type = ProductType.fromValue(product.type),
                amounts = product.amounts.map { amountResponse ->
                    Amount(
                        price = amountResponse.price,
                        weight = amountResponse.weight,
                        servings = amountResponse.servings
                    )
                }
            )
            productList.add(newProduct)
        }
        return productList
    }
}
