package com.marlonhndz.remotedatasource.models

import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING

data class ProductResponse(
    val `data`: Data,
    val kind: String
) {
    data class Data(
        val after: String,
        val before: String,
        val product: List<Product>,
        val dist: Int,
    ) {
        data class Product(
            var name: String = EMPTY_STRING,
            var description: String = EMPTY_STRING,
            var imageURL: String = EMPTY_STRING
        )
    }
}
