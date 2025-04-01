package com.barzabaldevs.ubiapp.di

import com.barzabaldevs.ubiapp.data.remote.GeocodingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProvider {
    private const val BASE_URL = "https://nominatim.openstreetmap.org/"

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun geocodingApiProvider(retrofit: Retrofit): GeocodingApi =
        retrofit.create(GeocodingApi::class.java)
}