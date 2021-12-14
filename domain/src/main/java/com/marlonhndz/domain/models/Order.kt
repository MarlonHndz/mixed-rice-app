package com.marlonhndz.domain.models

data class Order(
    val product: Product,
    val amount: Amount,
    val quantity: Int
)
