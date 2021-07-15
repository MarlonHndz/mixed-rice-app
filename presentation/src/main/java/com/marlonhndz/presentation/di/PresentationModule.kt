package com.marlonhndz.presentation.di

import com.marlonhndz.presentation.ui.products.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ProductViewModel(get()) }
}
