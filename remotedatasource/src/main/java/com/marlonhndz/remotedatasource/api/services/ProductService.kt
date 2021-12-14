package com.marlonhndz.remotedatasource.api.services

import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse
import retrofit2.http.GET

interface ProductService {

    @GET("/url")
    suspend fun getProduct(): MenuResponse
}
