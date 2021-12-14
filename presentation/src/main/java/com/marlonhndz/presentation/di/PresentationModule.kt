package com.marlonhndz.presentation.di

import com.marlonhndz.presentation.ui.productDetails.AmountAdapter
import com.marlonhndz.presentation.ui.productDetails.ProductDetailViewModel
import com.marlonhndz.presentation.ui.products.ProductAdapter
import com.marlonhndz.presentation.ui.products.ProductsViewModel
import com.marlonhndz.presentation.ui.shoppingcart.ShoppingCartAdapter
import com.marlonhndz.presentation.ui.shoppingcart.ShoppingCartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    // ViewModels
    viewModel { ProductsViewModel(get()) }
    viewModel { ProductDetailViewModel(get()) }
    viewModel { ShoppingCartViewModel(get()) }

    // Adapters
    factory { ProductAdapter() }
    factory { AmountAdapter() }
    factory { ShoppingCartAdapter() }
}
