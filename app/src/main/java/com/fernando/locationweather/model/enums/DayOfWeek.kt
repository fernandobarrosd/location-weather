package com.fernando.locationweather.model.enums

import android.os.Build.VERSION_CODES.O
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.DayOfWeek as DayOfWeekJava

enum class DayOfWeek(val fullName: String, val shortName: String) {
    MONDAY("Segunda", "Seg"),
    TUESDAY("Terça", "Ter"),
    WEDNESDAY("Quarta", "Qua"),
    THURSDAY("Quinta", "Qui"),
    FRIDAY("Sexta", "Sex"),
    SATURDAY("Sabado", "Sab"),
    SUNDAY("Sunday", "Sun");


    companion object {
        @RequiresApi(O)
        fun createFromLocalDate(localDate: LocalDate) : DayOfWeek {
            return when(localDate.dayOfWeek) {
                DayOfWeekJava.MONDAY -> MONDAY
                DayOfWeekJava.TUESDAY -> TUESDAY
                DayOfWeekJava.WEDNESDAY -> WEDNESDAY
                DayOfWeekJava.THURSDAY -> THURSDAY
                DayOfWeekJava.FRIDAY -> FRIDAY
                DayOfWeekJava.SATURDAY -> SATURDAY
                else -> SUNDAY
            }
        }
    }
}