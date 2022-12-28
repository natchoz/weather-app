package com.natcho.weatherapp.database

interface WeatherDataSource {
    suspend fun getCurrentWeatherInfo()
}