package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

class StateListColor(
    private val color: Color,
    private val disabledColor: Color = color,
    private val checkedColor: Color = color,
    private val selectedColor: Color = color,
    private val pressedColor: Color? = null,
) {
    fun getFrom(state: WidgetState): Color {
        return if (!state.enabled) {
            disabledColor
        } else if (pressedColor != null && state.pressed) {
            pressedColor
        } else if (state.selected) {
            selectedColor
        } else if (state.checked) {
            checkedColor
        } else {
            color
        }
    }

    companion object {
        fun defaults(): StateListColor {
            return StateListColor(
                color = Color.Black,
                disabledColor = Color.DarkGray,
                checkedColor = Color.Blue,
                selectedColor = Color.Red,
                pressedColor = Color.Green,
            )
        }

        @Composable
        internal fun sample(): StateListColor {
            return StateListColor(
                color = MaterialTheme.colorScheme.inversePrimary,
                disabledColor = MaterialTheme.colorScheme.surfaceVariant,
                checkedColor = MaterialTheme.colorScheme.inversePrimary,
                selectedColor = MaterialTheme.colorScheme.secondary,
                pressedColor = MaterialTheme.colorScheme.error,
            )
        }
    }
}

val LocalWidgetContentColor = compositionLocalOf { StateListColor.defaults() }