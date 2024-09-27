package com.example.skycast

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Se encarga de configurar la conexión a la API de WeatherAPI y proveer acceso a los servicios de la API.

object RetrofitClient {
    // Se crea la instancia de Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Retrofit genera una implementación de la interfaz `WeatherApiService` que se utilizará para hacer las solicitudes a la API.
    val api: WeatherApiService = retrofit.create(WeatherApiService::class.java)
}