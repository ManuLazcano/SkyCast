package com.example.skycast.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.skycast.databinding.ItemForecastBinding
import com.example.skycast.model.ForecastDay
import com.squareup.picasso.Picasso

class ForecastViewHolder(private val binding: ItemForecastBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(forecast: ForecastDay) {
        binding.tvDate.text = forecast.date
        binding.tvTempMinMax.text = "Min: ${forecast.day.mintemp_c}°C / Max: ${forecast.day.maxtemp_c}°C"
        Picasso.with(binding.ivWeatherIcon.context).load("https:${forecast.day.condition.icon}").into(binding.ivWeatherIcon)
    }
}