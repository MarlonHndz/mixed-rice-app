package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.AmountLocal
import com.marlonhndz.data.datasources.localdatasource.models.ProductLocal
import com.marlonhndz.domain.models.Amount
import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.models.ProductType

class OrderLocalToOrderMapper {

    operator fun invoke(productLocal: ProductLocal, amountLocal: AmountLocal, productQuantity: Int) =
        Order(
            product = Product(
                id = productLocal.productId,
                name = productLocal.name,
                description = productLocal.description,
                imageURL = productLocal.imageURL,
                type = ProductType.fromValue(productLocal.type),
                isFavorite = productLocal.isFavorite,
                amounts = listOf()
            ),
            amount = Amount(
                id = amountLocal.amountId,
                price = amountLocal.price,
                weight = amountLocal.weight,
                servings = amountLocal.servings
            ),
            quantity = productQuantity
        )
}
