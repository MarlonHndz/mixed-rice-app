package com.marlonhndz.domain.di

import com.marlonhndz.domain.useCases.GetProductUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetProductUseCase(get()) }
}
