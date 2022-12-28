package com.natcho.weatherapp.data.mapper

import com.natcho.weatherapp.domain.model.Coord
import com.natcho.weatherapp.domain.model.Main
import com.natcho.weatherapp.domain.model.Weather
import com.natcho.weatherapp.domain.model.WeatherInfo
import com.natcho.weatherapp.network.model.WeatherInfoDto

fun WeatherInfoDto.toDomain() = WeatherInfo(
    coord = Coord(
        lat = coord.lat,
        lon = coord.lon
    ),
//    weather = Weather(
//        id = weather.id,
//        main = weather.main,
//        description = weather.description,
//        icon = weather.icon,
//    ),
    main = Main(
        temp = main.temp,
        feelsLike = main.feelsLike,
        tempMin = main.tempMin,
        tempMax = main.tempMax,
        pressure = main.pressure,
        humidity = main.humidity,
    ),
    name = name,
)

