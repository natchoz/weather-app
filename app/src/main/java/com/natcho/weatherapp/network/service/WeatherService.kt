package com.natcho.weatherapp.network.service

import com.natcho.weatherapp.network.WeatherNetworkDataSource
import com.natcho.weatherapp.network.model.WeatherInfoDto
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface WeatherService {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherByGeoCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("units") units: String = "metric",
    ): WeatherInfoDto
}

class WeatherNetworkDataSourceImpl @Inject constructor(
    private val service: WeatherService,
) : WeatherNetworkDataSource {

    override suspend fun getCurrentWeatherByGeoCoordinates(
        latitude: Double,
        longitude: Double,
    ): WeatherInfoDto {
        return service.getCurrentWeatherByGeoCoordinates(latitude, longitude)
    }
}