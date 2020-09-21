package org.d3if4033.mobpro2.submission1

import android.app.Application
import org.d3if4033.mobpro2.submission1.core.di.databaseModule
import org.d3if4033.mobpro2.submission1.core.di.networkModule
import org.d3if4033.mobpro2.submission1.core.di.repositoryModule
import org.d3if4033.mobpro2.submission1.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}