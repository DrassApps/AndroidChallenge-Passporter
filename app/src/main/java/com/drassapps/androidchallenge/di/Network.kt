package com.drassapps.androidchallenge.di

import com.drassapps.androidchallenge.BuildConfig
import com.drassapps.androidchallenge.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    private val client = OkHttpClient.Builder()
        .readTimeout(1, TimeUnit.HOURS)
        .connectTimeout(1, TimeUnit.HOURS)
        .addInterceptor(ApiAuth(BuildConfig.API_KEY))
        .build()

    val service: ApiService = Retrofit.Builder()
        .baseUrl("https://api.github.com/users/drassapps/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .run { create(ApiService::class.java) }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}