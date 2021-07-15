package com.marlonhndz.data.di

import com.marlonhndz.data.repositories.ProductRepositoryImpl
import com.marlonhndz.domain.repositories.ProductRepository
import org.koin.dsl.module

val dataModule = module {
    factory <ProductRepository> { ProductRepositoryImpl(get(), get()) }
}
