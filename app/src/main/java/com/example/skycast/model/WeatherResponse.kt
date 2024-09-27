package com.example.skycast.model
import java.io.Serializable

data class WeatherResponse(
    val location: Location,
    val current: CurrentWeather,
    val forecast: Forecast
)

data class Location(
    val name: String,
    val localtime: String
)

data class CurrentWeather(
    val temp_c: Double,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String
) : Serializable

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day,
) : Serializable

data class Day(
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val condition: Condition
) : Serializable
