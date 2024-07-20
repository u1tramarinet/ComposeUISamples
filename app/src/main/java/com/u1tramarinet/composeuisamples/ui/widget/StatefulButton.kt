package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatefulButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val pressed by interactionSource.collectIsPressedAsState()
    val state = remember(enabled, selected, pressed) {
        WidgetState(enabled = enabled, selected = selected, pressed = pressed)
    }
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalWidgetState provides state
        ) {
            content()
        }
    }
}

@Composable
@Preview
fun StatefulButtonPreview() {
    val sampleColor = StateListColor.sample()
    Column {
        StatefulButton(
            onClick = { /*TODO*/ },
            selected = true,
        ) {
            StatefulText(text = "hello", color = sampleColor)
        }
        StatefulButton(
            onClick = { /*TODO*/ },
            enabled = false,
        ) {
            StatefulText(text = "hello", color = sampleColor)
        }
    }
}