package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

data class WidgetState(
    val enabled: Boolean = true,
    val selected: Boolean = false,
    val checked: Boolean = false,
    val pressed: Boolean = false,
)

val LocalWidgetState = compositionLocalOf { WidgetState() }

@Composable
fun ProvideWidgetState(value: WidgetState, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalWidgetState provides value, content = content)
}

@Composable
fun rememberWidgetState(
    enabled: Boolean,
    selected: Boolean = false,
    checked: Boolean = false,
    pressed: Boolean = false,
): WidgetState {
    return remember(enabled, selected, checked, pressed) {
        WidgetState(enabled = enabled, selected = selected, checked = checked, pressed = pressed)
    }
}

@Composable
fun rememberClickableWidgetState(
    enabled: Boolean = true,
    interactionSource: InteractionSource,
): WidgetState {
    val pressed by interactionSource.collectIsPressedAsState()
    return rememberWidgetState(enabled = enabled, pressed = pressed)
}

@Composable
fun rememberCheckableWidgetState(
    enabled: Boolean = true,
    checked: Boolean,
    interactionSource: InteractionSource? = null,
): WidgetState {
    val pressed = interactionSource?.collectIsPressedAsState()
    return rememberWidgetState(
        enabled = enabled,
        checked = checked,
        pressed = pressed?.value ?: false,
    )
}

@Composable
fun rememberSelectableWidgetState(
    enabled: Boolean = true,
    selected: Boolean,
    interactionSource: InteractionSource? = null,
): WidgetState {
    val pressed = interactionSource?.collectIsPressedAsState()
    return rememberWidgetState(
        enabled = enabled,
        selected = selected,
        pressed = pressed?.value ?: false,
    )
}