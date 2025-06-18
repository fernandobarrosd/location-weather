package com.fernando.locationweather.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fernando.locationweather.databinding.ItemWeatherBinding
import com.fernando.locationweather.model.Weather

class WeatherItemAdapter(private val weathers: List<Weather>)
    : RecyclerView.Adapter<WeatherItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = weathers.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val weather = weathers[position]
        viewHolder.bind(weather)
    }

    class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.dayOfWeekShortNameText.text = weather.dayOfWeek.shortName
            binding.temperatureText.text = "${weather.temperature}º"
        }
    }
}