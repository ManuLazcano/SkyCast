package com.example.skycast

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.skycast.databinding.ActivityMainBinding
import com.example.skycast.model.WeatherResponse
import com.example.skycast.viewModel.WeatherViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels() //'by viewModels()' permite que el ViewModel sea automáticamente gestionado por Android

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiKey = BuildConfig.WEATHER_API_KEY

        viewModel.fetchWeather(apiKey)

        // Observa los cambios en 'weatherData' en el ViewModel.
        viewModel.weatherData.observe(this) { weatherResponse ->
            weatherResponse?.let {// let -> Función de alcance, ejecuta el bloque de  código si el objeto no es nulo,
                updateUI(it)
            }
        }

    }

    private fun updateUI(weather: WeatherResponse) {
        binding.tvLocation.text = weather.location.name
        binding.tvCurrentTemp.text = "${weather.current.temp_c} °C"

        showPicture("https:" + weather.current.condition.icon)

        // Mostrar las temperaturas máxima y mínima
        val maxTemp = weather.forecast.forecastday[0].day.maxtemp_c
        val minTemp = weather.forecast.forecastday[0].day.mintemp_c
        binding.tvTempMinMax.text = "Min: $minTemp°C / Max: $maxTemp°C"
    }

    private fun showPicture(url: String) {
        Picasso.with(this).load(url).into(binding.ivWeatherIcon)
    }

}