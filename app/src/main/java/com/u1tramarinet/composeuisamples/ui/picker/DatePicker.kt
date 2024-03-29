package com.u1tramarinet.composeuisamples.ui.picker

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.u1tramarinet.composeuisamples.databinding.DatePickerBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.Date

@Composable
fun DatePicker(
    modifier: Modifier = Modifier,
    minDate: LocalDate = LocalDate.MIN,
    maxDate: LocalDate = LocalDate.MAX,
    date: LocalDate = LocalDate.now(),
    onDateChanged: (year: Int, monthValue: Int, dayOfMonth: Int) -> Unit = { _, _, _ -> },
) {
    val minDateTime = LocalDateTime.of(minDate, LocalTime.MIN).getTimeInMillis()
    val maxDateTime = LocalDateTime.of(maxDate, LocalTime.MAX).getTimeInMillis()
    AndroidViewBinding(
        DatePickerBinding::inflate,
        modifier = modifier
    ) {
        this.root.minDate = minDateTime
        this.root.maxDate = maxDateTime
        this.root.init(
            date.year,
            date.monthValue - 1,
            date.dayOfMonth,
        ) { _, year, monthOfYear, dayOfMonth ->
            onDateChanged(year, monthOfYear + 1, dayOfMonth)
        }
    }
}

private fun LocalDateTime.getTimeInMillis(): Long {
    val instant = this.toInstant(OffsetDateTime.now().offset)
    return Date.from(instant).time
}

@Preview(showBackground = true)
@Composable
private fun DatePickerPreview() {
    DatePicker(
        minDate = LocalDate.of(2024, 3, 2),
        maxDate = LocalDate.of(2024, 4, 30),
        date = LocalDate.of(2024, 3, 10)
    ) { year, monthValue, dayOfMonth ->
        Log.d("DatePicker", "year=${year}, month=${monthValue}, dayOfMonth=${dayOfMonth}")
    }
}