package com.example.cryptocurrencies

import com.github.mikephil.charting.formatter.ValueFormatter
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

// класс нужен для преобразования даты в строковый формат
// для отрисовки легенды оси X графика цены криптовалюты
class YearValueFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = value.toLong()
        return calendar.toFormatted()
    }

    fun Calendar.toFormatted(): String {
        val date = this.timeInMillis
        return date.dateToString("MMM yyyy")
    }
}

// используется в списке криптовалют для разделения порядков в числах
fun Float.formatThousands(): String {
    val stringBuilder = StringBuilder()
    val formatter = Formatter(stringBuilder, Locale.US)
    formatter.format("%(,.0f)", this)
    return stringBuilder.toString()
}

// используется для перевода дат из UNIX в строковый формат, для использования на графике
fun Number.dateToString(pattern: String): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong()
    return SimpleDateFormat(pattern).format(calendar.time)
}