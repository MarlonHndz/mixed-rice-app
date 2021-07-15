package com.marlonhndz.mixedrice

import android.app.Application
import com.marlonhndz.data.di.dataModule
import com.marlonhndz.domain.di.domainModule
import com.marlonhndz.localdatasource.di.localDataSourceModule
import com.marlonhndz.presentation.di.presentationModule
import com.marlonhndz.remotedatasource.di.remoteDataSourceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                domainModule,
                dataModule,
                presentationModule,
                remoteDataSourceModule,
                localDataSourceModule
            )
        }
    }
}
