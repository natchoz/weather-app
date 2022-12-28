package com.natcho.weatherapp.data.di

import com.natcho.weatherapp.data.repository.WeatherRepositoryImpl
import com.natcho.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindWeatherRepository(
        weatherRepository: WeatherRepositoryImpl
    ): WeatherRepository
}