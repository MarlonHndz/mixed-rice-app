package com.marlonhndz.presentation.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marlonhndz.domain.models.Product
import com.marlonhndz.domain.useCases.GetProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val _product: MutableLiveData<List<Product>> = MutableLiveData()

    val movies: LiveData<List<Product>>
        get() = _product

    fun fetchMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val postsList = getProductUseCase.getProduct()
                _product.postValue(postsList)
            }
        }
    }
}
