package com.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateManager {

    fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}