package com.marlonhndz.remotedatasource.datasources

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marlonhndz.data.commons.StringUtils.EMPTY_STRING
import com.marlonhndz.data.datasources.remotedatasource.MenuRemoteDataSource
import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse
import java.io.IOException

class MenuRemoteDataSourceImpl(
    private val context: Context
) : MenuRemoteDataSource {

    override suspend fun getMenuResponse(): MenuResponse {
        val jsonFileString = getJsonDataFromAsset(context, MENU_JSON_FILE_NAME)
        // Log.e(TAG, jsonFileString)

        val menuResponseType = object : TypeToken<MenuResponse>() {}.type
        val myMenuResponse: MenuResponse =
            Gson().fromJson(jsonFileString, menuResponseType)

        Log.e("--->data", "> Item:\n$myMenuResponse")

        return myMenuResponse
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
        const val TAG = "MenuRemoteDataSourceImpl"
        const val MENU_JSON_FILE_NAME = "mixed_rice_menu.json"
    }
}
