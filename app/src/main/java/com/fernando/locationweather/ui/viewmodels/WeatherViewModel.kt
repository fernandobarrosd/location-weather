package com.fernando.locationweather.ui.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernando.locationweather.model.Weather
import com.fernando.locationweather.model.enums.DayOfWeek
import java.time.LocalDate

class WeatherViewModel : ViewModel() {
    private val _weather: MutableLiveData<Weather> = MutableLiveData()
    val weather: LiveData<Weather>
        get() = _weather

    private val _weathers: MutableLiveData<List<Weather>> = MutableLiveData()
    val weathers: LiveData<List<Weather>>
        get() = _weathers

    @RequiresApi(Build.VERSION_CODES.O)
    fun initWeather() {
        _weather.postValue(Weather(
            temperature = 10.0,
            dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
        ))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initWeathers() {
        _weathers.postValue(listOf(
            Weather(
                temperature = 20.0,
                dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
            ),
            Weather(
                temperature = 20.0,
                dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
            ),
            Weather(
                temperature = 20.0,
                dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
            ),
            Weather(
                temperature = 20.0,
                dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
            ),
            Weather(
                temperature = 20.0,
                dayOfWeek = DayOfWeek.createFromLocalDate(LocalDate.now())
            )
        ))
    }
}