package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatefulIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: StateListColor = StateListColor(MaterialTheme.colorScheme.surface),
    state: WidgetState = LocalWidgetState.current,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint.getFrom(state),
    )
}

@Composable
@Preview
fun StatefulIconPreview() {
    val sampleColor = StateListColor.sample()
    Column {
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
        )
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
            tint = sampleColor,
        )
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
            tint = sampleColor,
            state = WidgetState(enabled = false)
        )
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
            tint = sampleColor,
            state = WidgetState(selected = true)
        )
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
            tint = sampleColor,
            state = WidgetState(checked = true)
        )
        StatefulIcon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
            tint = sampleColor,
            state = WidgetState(pressed = true)
        )
    }
}