package com.marlonhndz.localdatasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marlonhndz.data.datasources.localdatasource.models.OrderLocal

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(orders: List<OrderLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(order: OrderLocal)

    @Update
    fun updateOrder(order: OrderLocal)

    @Delete
    fun delete(order: OrderLocal)

    @Query("DELETE FROM `Order`")
    fun clearTable()

    @Query("SELECT * FROM `Order`")
    fun getAll(): List<OrderLocal>
}
