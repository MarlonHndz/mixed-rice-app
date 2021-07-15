package com.marlonhndz.remotedatasource.datasources

import com.marlonhndz.data.datasources.ProductRemoteDataSource
import com.marlonhndz.domain.models.Product
import com.marlonhndz.remotedatasource.api.services.ProductService
import com.marlonhndz.remotedatasource.mappers.ProductResponseToProductMapper
import com.marlonhndz.remotedatasource.models.ProductResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteDataSourceImpl(
    private val productService: ProductService,
    private val productResponseToProductMapper: ProductResponseToProductMapper
) : ProductRemoteDataSource {

    override suspend fun getProductList(): List<Product> {
        // Create here the RetroFit request and change the return
        withContext(Dispatchers.IO) {
            val response = productService.getProduct()
            productResponseToProductMapper(response)
        }
        return productResponseToProductMapper(getRemoteProduct())
    }

    private fun getRemoteProduct() = ProductResponse(
        kind = "",
        data = ProductResponse.Data(
            after = "",
            before = "",
            dist = 0,
            product = mutableListOf()
        )
    )
}
