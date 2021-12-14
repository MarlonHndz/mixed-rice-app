package com.marlonhndz.domain.di

import com.marlonhndz.domain.useCases.OrderUseCase
import com.marlonhndz.domain.useCases.ProductsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { ProductsUseCase(get()) }
    factory { OrderUseCase(get()) }
}
