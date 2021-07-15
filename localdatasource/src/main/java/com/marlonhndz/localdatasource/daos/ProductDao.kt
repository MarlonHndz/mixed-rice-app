package com.marlonhndz.localdatasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marlonhndz.localdatasource.models.ProductLocal

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<ProductLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: ProductLocal)

    @Update
    fun updateProduct(product: ProductLocal)

    @Delete
    fun delete(product: ProductLocal)

    @Query("SELECT * FROM product")
    fun getAll(): List<ProductLocal>

    @Query("SELECT * FROM product WHERE name = :name LIMIT 1")
    fun getProductByName(name: String): ProductLocal

    @Query("SELECT * FROM product WHERE isFavorite = 1")
    fun getFavoriteProducts(): List<ProductLocal>
}
