package com.example.skycast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skycast.adapter.ForecastAdapter
import com.example.skycast.databinding.ActivityForecastBinding
import com.example.skycast.model.ForecastDay

class ForecastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForecastBinding
    private lateinit var forecastAdapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /// Obtener la lista pasada por el Intent
        val forecastList = intent.getSerializableExtra("forecastList") as? List<ForecastDay> ?: emptyList()

        initRecycler(forecastList)
    }

    private fun initRecycler(forecastList: List<ForecastDay>) {
        binding.recyclerViewForecast.layoutManager = LinearLayoutManager(this)
        forecastAdapter = ForecastAdapter(forecastList)
        binding.recyclerViewForecast.adapter = forecastAdapter
    }
}