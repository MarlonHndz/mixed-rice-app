package com.marlonhndz.data.datasources.remotedatasource

import com.marlonhndz.data.datasources.remotedatasource.models.MenuResponse

interface MenuRemoteDataSource {
    suspend fun getMenuResponse(): MenuResponse
}
