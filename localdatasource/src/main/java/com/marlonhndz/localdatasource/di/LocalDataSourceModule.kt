package com.marlonhndz.localdatasource.di

import com.marlonhndz.data.datasources.ProductLocalDataSource
import com.marlonhndz.localdatasource.AppDatabase
import com.marlonhndz.localdatasource.datasources.ProductLocalDataSourceImpl
import com.marlonhndz.localdatasource.mappers.ProductLocalToProductMapper
import com.marlonhndz.localdatasource.mappers.ProductToProductLocalMapper
import org.koin.dsl.module

val localDataSourceModule = module {
    // Database
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().productDao() }

    // Mappers
    factory { ProductLocalToProductMapper() }
    factory { ProductToProductLocalMapper() }

    // DataSources
    factory<ProductLocalDataSource> { ProductLocalDataSourceImpl(get(), get(), get()) }
}
