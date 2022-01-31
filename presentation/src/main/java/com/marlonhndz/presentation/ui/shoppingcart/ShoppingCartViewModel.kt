package com.marlonhndz.presentation.ui.shoppingcart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marlonhndz.domain.models.Order
import com.marlonhndz.domain.useCases.OrderUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShoppingCartViewModel(
    private val orderUseCase: OrderUseCase
) : ViewModel() {

    private val _ordersList: MutableLiveData<List<Order>> = MutableLiveData()

    val ordersList: LiveData<List<Order>>
        get() = _ordersList

    fun fetchOrders() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val ordersList = orderUseCase.getOrders()
                _ordersList.postValue(ordersList)
            }
        }
    }

    fun clearOrderList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orderUseCase.clearOrderList()
            }
        }
    }

    fun updateOrder(newOrder: Order) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orderUseCase.updateOrder(newOrder)
            }
        }
    }

    fun deleteOrderFromList(order: Order) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orderUseCase.deleteOrderFromList(order)
            }
        }
    }
}
