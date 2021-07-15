package com.marlonhndz.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marlonhndz.localdatasource.daos.ProductDao
import com.marlonhndz.localdatasource.models.ProductLocal

@Database(entities = [ProductLocal::class], version = AppDatabase.DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

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

        // Tables' name
        const val PRODUCT_TABLE_NAME = "Product"
    }
}
