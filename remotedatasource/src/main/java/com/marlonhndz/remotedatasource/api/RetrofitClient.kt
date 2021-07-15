package com.marlonhndz.remotedatasource.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Urls.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)
}
