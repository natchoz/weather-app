package com.natcho.weatherapp.network.di

import com.natcho.weatherapp.network.WeatherNetworkDataSource
import com.natcho.weatherapp.network.service.RequestInterceptor
import com.natcho.weatherapp.network.service.WeatherNetworkDataSourceImpl
import com.natcho.weatherapp.network.service.WeatherService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org")
            .client(
                OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherNetworkDataSource(service: WeatherService): WeatherNetworkDataSource {
        return WeatherNetworkDataSourceImpl(service)
    }
}

// This also works
//@Module
//@InstallIn(SingletonComponent::class)
//interface NetworkDataSourceModule {
//
//    @Binds
//    fun bindWeatherNetworkDataSource(
//        WeatherNetworkDataSource: WeatherNetworkDataSourceImpl
//    ) : WeatherNetworkDataSource
//}