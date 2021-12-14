package com.marlonhndz.presentation.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.useCases.ProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsViewModel(
    private val productsUseCase: ProductsUseCase
) : ViewModel() {

    private val _productsList: MutableLiveData<List<Product>> = MutableLiveData()

    val productsList: LiveData<List<Product>>
        get() = _productsList

    fun fetchProducts() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val productsList = productsUseCase.getProducts()
                _productsList.postValue(productsList)
            }
        }
    }
}
