package com.marlonhndz.data.datasources.localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marlonhndz.data.commons.LocalDbTableNames.PRODUCT_TABLE_NAME
import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING

@Entity(tableName = PRODUCT_TABLE_NAME)
data class ProductLocal(
    @PrimaryKey @ColumnInfo(name = "product_id") val productId: String,
    @ColumnInfo(name = "name") val name: String = EMPTY_STRING,
    @ColumnInfo(name = "description") val description: String = EMPTY_STRING,
    @ColumnInfo(name = "image_url") val imageURL: String = EMPTY_STRING,
    @ColumnInfo(name = "type") val type: String = EMPTY_STRING,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean = false
)
