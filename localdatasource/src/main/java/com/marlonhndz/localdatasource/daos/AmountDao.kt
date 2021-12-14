package com.marlonhndz.localdatasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marlonhndz.data.datasources.localdatasource.models.AmountLocal

@Dao
interface AmountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(amounts: List<AmountLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(amount: AmountLocal)

    @Update
    fun updateAmount(amount: AmountLocal)

    @Delete
    fun delete(amount: AmountLocal)

    @Query("SELECT * FROM amount")
    fun getAll(): List<AmountLocal>

    @Query("SELECT * FROM amount WHERE amount_id = :id LIMIT 1")
    fun getAmountByID(id: String): AmountLocal
}
