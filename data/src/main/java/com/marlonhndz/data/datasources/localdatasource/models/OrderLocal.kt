package com.marlonhndz.data.datasources.localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marlonhndz.data.commons.LocalDbTableNames.ORDER_TABLE_NAME
import com.marlonhndz.data.commons.StringUtils

@Entity(tableName = ORDER_TABLE_NAME)
data class OrderLocal(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "order_id") val orderId: Long = 0,
    @ColumnInfo(name = "product_id") val productId: String = StringUtils.EMPTY_STRING,
    @ColumnInfo(name = "product_quantity") val productQuantity: Int = 0,
    @ColumnInfo(name = "amount_id") val amountId: String = StringUtils.EMPTY_STRING
)
