package com.marlonhndz.data.datasources.localdatasource.models

import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithAmounts(
    @Embedded val productLocal: ProductLocal,
    @Relation(
        parentColumn = "product_id",
        entityColumn = "product_owner_id"
    )
    val amounts: List<AmountLocal>
)
