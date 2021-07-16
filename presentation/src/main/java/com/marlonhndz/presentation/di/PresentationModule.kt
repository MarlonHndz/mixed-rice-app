package com.marlonhndz.presentation.di

import com.marlonhndz.presentation.ui.productDetails.AmountAdapter
import com.marlonhndz.presentation.ui.products.ProductAdapter
import com.marlonhndz.presentation.ui.products.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    // ViewModels
    viewModel { ProductViewModel(get()) }

    // Adapters
    factory { ProductAdapter() }
    factory { AmountAdapter() }
}
