package com.marlonhndz.presentation.ui.productDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.useCases.OrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailViewModel(
    private val orderUseCase: OrderUseCase
) : ViewModel() {

    fun addProductToOrder(product: Product) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orderUseCase.addProductToOrder(product)
            }
        }
    }
}
