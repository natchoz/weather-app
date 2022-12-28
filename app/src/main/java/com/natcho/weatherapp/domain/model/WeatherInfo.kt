package com.natcho.weatherapp.domain.model

data class WeatherInfo(
    val coord: Coord,
//    val weather: Weather,
    val main: Main,
    val name: String,
)

data class Coord(
    val lon: Double,
    val lat: Double,
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
)
