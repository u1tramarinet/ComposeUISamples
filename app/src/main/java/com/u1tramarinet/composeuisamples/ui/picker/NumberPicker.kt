package com.u1tramarinet.composeuisamples.ui.picker

import android.util.Log
import android.widget.NumberPicker
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun NumberPicker(
    modifier: Modifier = Modifier,
    minValue: Int = 0,
    maxValue: Int = 10,
    value: Int = 5,
    formatter: @Composable (value: Int) -> String = { it.toString() },
    onValueChange: (value: Int) -> Unit = {},
) {
    val displayedValues: List<String> = (minValue..maxValue).map { formatter(it) }
    AndroidView(
        modifier = modifier,
        factory = { context ->
            NumberPicker(context).apply {
                this.minValue = minValue
                this.maxValue = maxValue
                this.value = value
                setDisplayedValues(displayedValues.toTypedArray())
                setOnValueChangedListener { _, _, newValue -> onValueChange(newValue) }
            }
        },
    )
}

@Composable
fun <Item: NumberPickerItem> TypedNumberPicker(
    modifier: Modifier = Modifier,
    items: List<Item>,
    onValueChange: (item: Item) -> Unit = {},
) {
    NumberPicker(
        modifier = modifier,
        minValue = 0,
        maxValue = items.lastIndex,
        formatter = { value -> items[value].format() },
        onValueChange = { value -> onValueChange(items[value]) }
    )
}

@Preview(showBackground = true)
@Composable
private fun NumberPickerPreview() {
    NumberPicker(modifier = Modifier.fillMaxSize()) { value ->
        Log.d("NumberPicker", "onValueChange($value)")
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberPickerPreview2() {
    val items: List<NumberPickerItemSample> = listOf(
        NumberPickerItemSample(0),
        NumberPickerItemSample(1),
        NumberPickerItemSample(2),
        NumberPickerItemSample(3),
    )
    TypedNumberPicker(modifier = Modifier.fillMaxSize(), items = items) { value ->
        Log.d("NumberPicker", "onValueChange(${value})")
    }
}

interface NumberPickerItem {
    @Composable
    fun format(): String
}

class NumberPickerItemSample(private val index: Int) : NumberPickerItem {
    @Composable
    override fun format(): String {
        return "sample: $index"
    }
}