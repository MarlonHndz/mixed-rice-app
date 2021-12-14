package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.OrderLocal
import com.marlonhndz.domain.models.Product

class ProductToOrderLocalMapper {

    operator fun invoke(product: Product) =
        OrderLocal(
            productId = product.id,
            productQuantity = 1,
            amountId = product.amounts[0].id
        )
}
