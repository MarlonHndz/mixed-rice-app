package com.marlonhndz.localdatasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.marlonhndz.data.datasources.localdatasource.models.ProductLocal
import com.marlonhndz.data.datasources.localdatasource.models.ProductWithAmounts

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

    @Query("SELECT * FROM product WHERE product_id = :id LIMIT 1")
    fun getProductByID(id: String): ProductLocal

    @Query("SELECT * FROM product WHERE is_favorite = 1")
    fun getFavoriteProducts(): List<ProductLocal>

    @Transaction
    @Query("SELECT * FROM product")
    fun getAllProductsWithAmountList(): List<ProductWithAmounts>
}
