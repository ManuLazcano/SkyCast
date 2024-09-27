package com.example.skycast

import com.example.skycast.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// WeatherApiService define los endpoints de la API que Retrofit usará para hacer las solicitudes HTTP.
// Cada función en la interfaz representa un endpoint específico de la API de WeatherAPI.

interface WeatherApiService {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String = "Buenos Aires",
        @Query("days") days: Int = 6,
    ): Response<WeatherResponse>
}