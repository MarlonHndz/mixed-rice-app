package com.marlonhndz.data.di

import com.marlonhndz.data.mappers.MenuResponseToAmountsByProductMapper
import com.marlonhndz.data.mappers.MenuResponseToProductsLocalMapper
import com.marlonhndz.data.mappers.OrderLocalToOrderMapper
import com.marlonhndz.data.mappers.ProductToOrderLocalMapper
import com.marlonhndz.data.mappers.ProductsWithAmountsLocalToProductMapper
import com.marlonhndz.data.repositories.OrderRepositoryImpl
import com.marlonhndz.data.repositories.ProductRepositoryImpl
import com.marlonhndz.domain.repositories.OrderRepository
import com.marlonhndz.domain.repositories.ProductRepository
import org.koin.dsl.module

val dataModule = module {
    // Repositories
    factory<ProductRepository> { ProductRepositoryImpl(get(), get()) }
    factory<OrderRepository> { OrderRepositoryImpl(get()) }

    // Mappers
    factory { MenuResponseToProductsLocalMapper() }
    factory { MenuResponseToAmountsByProductMapper() }
    factory { ProductsWithAmountsLocalToProductMapper() }
    factory { ProductToOrderLocalMapper() }
    factory { OrderLocalToOrderMapper() }
}
