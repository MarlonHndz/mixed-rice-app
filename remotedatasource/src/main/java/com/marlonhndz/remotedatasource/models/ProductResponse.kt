package com.marlonhndz.remotedatasource.models

import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING

data class ProductResponse(
    val status: Int,
    val data: Data
) {
    data class Data(
        val after: String,
        val before: String,
        val dist: String,
        val products: List<Product>
    ) {
        data class Product(
            var id: String = EMPTY_STRING,
            var name: String = EMPTY_STRING,
            var description: String = EMPTY_STRING,
            var type: String = EMPTY_STRING,
            var image: String = EMPTY_STRING,
            val amounts: List<Amount>
        ) {
            data class Amount(
                var price: Int = 0,
                var weight: String = EMPTY_STRING,
                var servings: String = EMPTY_STRING
            )
        }
    }
}
