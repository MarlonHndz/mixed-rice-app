package com.marlonhndz.domain.models

data class Order(
    val id: Long,
    val product: Product,
    val amount: Amount,
    var quantity: Int
)
