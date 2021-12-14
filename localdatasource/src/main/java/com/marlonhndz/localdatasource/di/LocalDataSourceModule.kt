package com.marlonhndz.localdatasource.di

import com.marlonhndz.data.datasources.localdatasource.OrderLocalDataSource
import com.marlonhndz.data.datasources.localdatasource.ProductLocalDataSource
import com.marlonhndz.localdatasource.AppDatabase
import com.marlonhndz.localdatasource.datasources.OrderLocalDataSourceImpl
import com.marlonhndz.localdatasource.datasources.ProductLocalDataSourceImpl
import org.koin.dsl.module

val localDataSourceModule = module {
    // Database
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().productDao() }
    single { get<AppDatabase>().amountDao() }
    single { get<AppDatabase>().orderDao() }

    // DataSources
    factory<ProductLocalDataSource> { ProductLocalDataSourceImpl(get(), get(), get(), get()) }
    factory<OrderLocalDataSource> { OrderLocalDataSourceImpl(get(), get(), get()) }
}
