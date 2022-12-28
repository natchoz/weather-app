package com.natcho.weatherapp.domain.repository

import com.natcho.weatherapp.common.result.Result
import com.natcho.weatherapp.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getCurrentWeatherByGeoCoordinates(
        lat: Double,
        lon: Double
    ): Result<WeatherInfo>
}