package com.natcho.weatherapp.data.repository

import android.util.Log
import com.natcho.weatherapp.common.result.Result
import com.natcho.weatherapp.data.mapper.toDomain
import com.natcho.weatherapp.domain.model.WeatherInfo
import com.natcho.weatherapp.domain.repository.WeatherRepository
import com.natcho.weatherapp.network.WeatherNetworkDataSource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val networkDataSource: WeatherNetworkDataSource
) : WeatherRepository {

    override suspend fun getCurrentWeatherByGeoCoordinates(
        lat: Double,
        lon: Double
    ): Result<WeatherInfo> {
        return try {
            Result.Success(
                data = networkDataSource.getCurrentWeatherByGeoCoordinates(lat, lon).toDomain()
            )
        } catch (e: Exception) {
            Log.e("WeatherApp", e.stackTraceToString())
            Result.Error(e)
        }
    }
}