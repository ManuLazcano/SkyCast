package com.example.skycast.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skycast.RetrofitClient
import com.example.skycast.model.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    // _weatherData es una variable privada que contiene los datos del clima. MutableLiveData permite modificar sus valores.
    private val _weatherData = MutableLiveData<WeatherResponse>()

    // weatherData es la versión pública de _weatherData. Solo expone una LiveData, por lo que no puede ser modificada
    // desde afuera del ViewModel, lo que asegura que la UI solo puede observar los cambios.
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    fun fetchWeather(apiKey: String) {
        // viewModelScope.launch para ejecutar la llamada en un hilo de fondo utilizando corrutinas,
        // lo que evita bloquear el hilo principal.
        viewModelScope.launch {
            val response = RetrofitClient.api.getWeatherForecast(apiKey)

            if (response.isSuccessful) {
                // Desencadena la actualización de los observadores (la UI).
                _weatherData.value = response.body()
            }
        }
    }
}