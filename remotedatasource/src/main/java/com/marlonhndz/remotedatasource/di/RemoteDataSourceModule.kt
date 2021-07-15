package com.marlonhndz.remotedatasource.di

import com.marlonhndz.data.datasources.ProductRemoteDataSource
import com.marlonhndz.remotedatasource.api.RetrofitClient
import com.marlonhndz.remotedatasource.api.services.ProductService
import com.marlonhndz.remotedatasource.datasources.ProductRemoteDataSourceImpl
import com.marlonhndz.remotedatasource.mappers.ProductResponseToProductMapper
import org.koin.dsl.module

val remoteDataSourceModule = module {
    // Mappers
    factory { ProductResponseToProductMapper() }

    // APIs
    single<ProductService> { RetrofitClient.create(ProductService::class.java) }

    // DataSources
    factory<ProductRemoteDataSource> { ProductRemoteDataSourceImpl(get(), get()) }
}
