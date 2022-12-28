package com.natcho.weatherapp.network.model

import com.squareup.moshi.Json

data class WeatherInfoDto(
    @Json(name = "coord") val coord: CoordDto,
//    @Json(name = "weather") val weather: WeatherDto,
    @Json(name = "main") val main: MainDto,
    @Json(name = "name") val name: String,
)

data class CoordDto(
    @Json(name = "lon") val lon: Double,
    @Json(name = "lat") val lat: Double,
)

data class WeatherDto(
    @Json(name = "id") val id: Int,
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)

data class MainDto(
    @Json(name = "temp") val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "temp_min") val tempMin: Double,
    @Json(name = "temp_max") val tempMax: Double,
    @Json(name = "pressure") val pressure: Int,
    @Json(name = "humidity") val humidity: Int,
)
