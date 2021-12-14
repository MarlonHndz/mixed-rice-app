package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.AmountLocal
import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse

class MenuResponseToAmountsByProductMapper {

    operator fun invoke(menuResponse: MenuResponse, productId: String): List<AmountLocal> {
        with(menuResponse) {
            return data.products.first { product -> product.id == productId }.amounts.map { amountResponse ->
                AmountLocal(
                    amountId = amountResponse.id,
                    productOwnerId = productId,
                    price = amountResponse.price,
                    weight = amountResponse.weight,
                    servings = amountResponse.servings
                )
            }
        }
    }
}
