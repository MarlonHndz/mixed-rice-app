package com.marlonhndz.remotedatasource.api.services

import com.marlonhndz.remotedatasource.models.ProductResponse
import retrofit2.http.GET

interface ProductService {

    @GET("/url")
    suspend fun getProduct(): ProductResponse
}
