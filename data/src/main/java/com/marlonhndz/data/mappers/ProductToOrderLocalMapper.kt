package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.OrderLocal
import com.marlonhndz.domain.models.Product

class ProductToOrderLocalMapper {

    operator fun invoke(product: Product, productQuantity: Int) =
        OrderLocal(
            productId = product.id,
            productQuantity = productQuantity,
            amountId = product.amounts[0].id
        )
}
