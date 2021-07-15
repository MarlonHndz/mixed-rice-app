package com.marlonhndz.localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING
import com.marlonhndz.localdatasource.AppDatabase.Companion.PRODUCT_TABLE_NAME

@Entity(tableName = PRODUCT_TABLE_NAME)
data class ProductLocal(
    @PrimaryKey @ColumnInfo(name = "name") val name: String = EMPTY_STRING,
    @ColumnInfo(name = "description") val description: String = EMPTY_STRING,
    @ColumnInfo(name = "imageURL") val imageURL: String = EMPTY_STRING,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false
)
