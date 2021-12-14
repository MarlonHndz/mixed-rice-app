package com.marlonhndz.localdatasource.datasources

import com.marlonhndz.data.datasources.localdatasource.ProductLocalDataSource
import com.marlonhndz.data.datasources.localdatasource.models.AmountLocal
import com.marlonhndz.data.datasources.localdatasource.models.ProductLocal
import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse
import com.marlonhndz.data.mappers.MenuResponseToAmountsByProductMapper
import com.marlonhndz.data.mappers.MenuResponseToProductsLocalMapper
import com.marlonhndz.data.mappers.ProductsWithAmountsLocalToProductMapper
import com.marlonhndz.domain.models.Product
import com.marlonhndz.localdatasource.AppDatabase

class ProductLocalDataSourceImpl(
    private val appDatabase: AppDatabase,
    private val menuResponseToProductsLocalMapper: MenuResponseToProductsLocalMapper,
    private val menuResponseToAmountsByProductMapper: MenuResponseToAmountsByProductMapper,
    private val productsWithAmountsLocalToProductMapper: ProductsWithAmountsLocalToProductMapper
) : ProductLocalDataSource {

    override suspend fun insertMenu(menuResponse: MenuResponse) {
        val productsList: List<ProductLocal> = menuResponseToProductsLocalMapper(menuResponse)
        appDatabase.productDao().insertAll(productsList)

        productsList.forEach { productLocal ->
            val amountsList: List<AmountLocal> =
                menuResponseToAmountsByProductMapper(menuResponse, productLocal.productId)
            appDatabase.amountDao().insertAll(amountsList)
        }
    }

    override suspend fun getProductList(): List<Product> {
        return productsWithAmountsLocalToProductMapper(appDatabase.productDao().getAllProductsWithAmountList())
    }
}
