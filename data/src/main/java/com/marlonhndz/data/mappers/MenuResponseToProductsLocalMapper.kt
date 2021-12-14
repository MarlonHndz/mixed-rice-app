package com.marlonhndz.data.mappers

import com.marlonhndz.data.datasources.localdatasource.models.ProductLocal
import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse

class MenuResponseToProductsLocalMapper {

    operator fun invoke(menuResponse: MenuResponse): List<ProductLocal> {
        with(menuResponse) {
            return data.products.map { productResponse ->
                ProductLocal(
                    productId = productResponse.id,
                    name = productResponse.name,
                    description = productResponse.description,
                    imageURL = productResponse.image,
                    type = productResponse.type,
                    isFavorite = false
                )
            }
        }
    }
}
