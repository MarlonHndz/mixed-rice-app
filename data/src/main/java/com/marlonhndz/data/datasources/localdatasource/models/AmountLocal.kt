package com.marlonhndz.data.datasources.localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marlonhndz.data.commons.LocalDbTableNames.AMOUNT_TABLE_NAME
import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING

@Entity(tableName = AMOUNT_TABLE_NAME)
data class AmountLocal(
    @PrimaryKey @ColumnInfo(name = "amount_id") val amountId: String,
    @ColumnInfo(name = "product_owner_id") val productOwnerId: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "weight") val weight: String = EMPTY_STRING,
    @ColumnInfo(name = "servings") val servings: String = EMPTY_STRING,
    @ColumnInfo(name = "isSelected") val isSelected: Boolean = false
)
