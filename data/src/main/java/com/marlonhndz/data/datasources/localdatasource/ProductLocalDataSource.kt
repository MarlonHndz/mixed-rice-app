package com.marlonhndz.data.datasources.localdatasource

import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse
import com.marlonhndz.domain.models.Product

interface ProductLocalDataSource {
    suspend fun insertMenu(menuResponse: MenuResponse)
    suspend fun getProductList(): List<Product>
}
