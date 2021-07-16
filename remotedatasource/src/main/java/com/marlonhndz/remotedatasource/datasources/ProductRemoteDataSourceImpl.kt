package com.marlonhndz.remotedatasource.datasources

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING
import com.marlonhndz.data.datasources.ProductRemoteDataSource
import com.marlonhndz.domain.models.Product
import com.marlonhndz.remotedatasource.mappers.ProductResponseToProductMapper
import com.marlonhndz.remotedatasource.models.ProductResponse
import java.io.IOException

class ProductRemoteDataSourceImpl(
    private val context: Context,
    private val productResponseToProductMapper: ProductResponseToProductMapper
) : ProductRemoteDataSource {

    override suspend fun getProductList(): List<Product> {
        val jsonFileString = getJsonDataFromAsset(context, MENU_JSON_FILE_NAME)
        // Log.e(TAG, jsonFileString)

        val productResponseType = object : TypeToken<ProductResponse>() {}.type
        val myProductResponse: ProductResponse =
            Gson().fromJson(jsonFileString, productResponseType)

        Log.e("--->data", "> Item:\n$myProductResponse")

        return productResponseToProductMapper(myProductResponse)
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return EMPTY_STRING
        }
        return jsonString
    }

    companion object {
        const val TAG = "ProductRemoteData"
        const val MENU_JSON_FILE_NAME = "mixed_rice_menu.json"
    }
}
