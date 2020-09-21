package org.d3if4033.mobpro2.submission1.core.di

import androidx.room.Room
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.d3if4033.mobpro2.submission1.core.data.BanyuwangiRepository
import org.d3if4033.mobpro2.submission1.core.data.source.local.LocalDataSource
import org.d3if4033.mobpro2.submission1.core.data.source.local.room.BanyuwangiDatabase
import org.d3if4033.mobpro2.submission1.core.data.source.remote.RemoteDataSource
import org.d3if4033.mobpro2.submission1.core.data.source.remote.network.ApiService
import org.d3if4033.mobpro2.submission1.core.domain.repository.IBanyuwangiRepository
import org.d3if4033.mobpro2.submission1.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<BanyuwangiDatabase>().banyuwangiDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            BanyuwangiDatabase::class.java, "Banyuwangi.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://firebasestorage.googleapis.com/v0/b/submission-c1bd0.appspot.com/o/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IBanyuwangiRepository> { BanyuwangiRepository(get(), get(), get()) }
}