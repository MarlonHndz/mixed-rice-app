package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.ProductWithAmounts
import com.marlonhndz.domain.models.Amount
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.models.ProductType

class ProductsWithAmountsLocalToProductMapper {

    operator fun invoke(listProductLocal: List<ProductWithAmounts>): List<Product> {
        return listProductLocal.map {
            Product(
                id = it.productLocal.productId,
                name = it.productLocal.name,
                description = it.productLocal.description,
                imageURL = it.productLocal.imageURL,
                type = ProductType.fromValue(it.productLocal.type),
                isFavorite = it.productLocal.isFavorite,
                amounts = it.amounts.map { amountLocal ->
                    Amount(
                        id = amountLocal.amountId,
                        price = amountLocal.price,
                        weight = amountLocal.weight,
                        servings = amountLocal.servings
                    )
                }
            )
        }
    }
}
