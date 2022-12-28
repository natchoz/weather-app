package com.natcho.weatherapp.network

import com.natcho.weatherapp.common.result.Result
import com.natcho.weatherapp.network.model.WeatherInfoDto

interface WeatherNetworkDataSource {
    suspend fun getCurrentWeatherByGeoCoordinates(
        lat: Double,
        lon: Double,
    ): WeatherInfoDto
}