package com.u1tramarinet.composeuisamples.ui.picker

import android.text.InputType
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.u1tramarinet.composeuisamples.databinding.DatePickerBinding
import java.time.LocalDate
import java.time.ZoneOffset

@Composable
fun DatePicker(
    modifier: Modifier = Modifier,
    minDate: LocalDate = LocalDate.MIN,
    maxDate: LocalDate = LocalDate.MAX,
    date: LocalDate = LocalDate.now(),
    onDateChanged: (year: Int, monthValue: Int, dayOfMonth: Int) -> Unit = { _, _, _ -> },
) {
    AndroidViewBinding(
        DatePickerBinding::inflate,
        modifier = modifier
    ) {
        this.root.minDate = minDate.atStartOfDay().toEpochSecond(ZoneOffset.ofHours(9))
        this.root.maxDate = maxDate.atStartOfDay().toEpochSecond(ZoneOffset.ofHours(9))
        this.root.init(
            date.year,
            date.monthValue - 1,
            date.dayOfMonth,
        ) { _, year, monthOfYear, dayOfMonth ->
            onDateChanged(year, monthOfYear + 1, dayOfMonth)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DatePickerPreview() {
    DatePicker(
        minDate = LocalDate.of(2024, 3, 2),
        maxDate = LocalDate.of(2024, 3, 30),
        date = LocalDate.of(2024, 3, 10)
    ) { year, monthValue, dayOfMonth ->
        Log.d("DatePicker", "year=${year}, month=${monthValue}, dayOfMonth=${dayOfMonth}")
    }
}