package com.fernando.locationweather.model

import com.fernando.locationweather.model.enums.DayOfWeek

class Weather {
    private val _temperature: Double
    val temperature: Double
        get() = _temperature

    private val _dayOfWeek: DayOfWeek
    val dayOfWeek: DayOfWeek
        get() = _dayOfWeek

    constructor(temperature: Double, dayOfWeek: DayOfWeek) {
        this._temperature = temperature
        this._dayOfWeek = dayOfWeek
    }
}