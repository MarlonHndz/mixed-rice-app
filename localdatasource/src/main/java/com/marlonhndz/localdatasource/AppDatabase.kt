package com.marlonhndz.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marlonhndz.data.datasources.localdatasource.models.AmountLocal
import com.marlonhndz.data.datasources.localdatasource.models.OrderLocal
import com.marlonhndz.data.datasources.localdatasource.models.ProductLocal
import com.marlonhndz.localdatasource.daos.AmountDao
import com.marlonhndz.localdatasource.daos.OrderDao
import com.marlonhndz.localdatasource.daos.ProductDao

@Database(
    entities = [ProductLocal::class, AmountLocal::class, OrderLocal::class],
    version = AppDatabase.DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun amountDao(): AmountDao
    abstract fun orderDao(): OrderDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()

        private var INSTANCE: AppDatabase? = null
        private const val DATABASE_NAME = "name_database"
        const val DATABASE_VERSION = 1
    }
}
