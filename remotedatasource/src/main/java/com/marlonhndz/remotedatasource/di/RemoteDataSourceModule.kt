package com.marlonhndz.remotedatasource.di

import com.marlonhndz.data.datasources.remotedatasource.MenuRemoteDataSource
import com.marlonhndz.remotedatasource.api.RetrofitClient
import com.marlonhndz.remotedatasource.api.services.ProductService
import com.marlonhndz.remotedatasource.datasources.MenuRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    // APIs
    single<ProductService> { RetrofitClient.create(ProductService::class.java) }

    // DataSources
    factory<MenuRemoteDataSource> { MenuRemoteDataSourceImpl(get()) }
}
