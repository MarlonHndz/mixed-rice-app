package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.OrderLocal
import com.marlonhndz.domain.models.Order

class OrderToOrderLocalMapper {

    operator fun invoke(order: Order) =
        OrderLocal(
            orderId = order.id,
            productId = order.product.id,
            amountId = order.amount.id,
            productQuantity = order.quantity
        )
}
