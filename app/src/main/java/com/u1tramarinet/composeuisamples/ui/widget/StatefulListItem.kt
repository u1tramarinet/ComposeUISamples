package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefulListItem(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier.padding(16.dp)) {
        ProvideWidgetState(value = WidgetState(enabled = enabled)) {
            content()
        }
    }
}

@Composable
@Preview
fun StatefulListItemPreview() {
    val sampleColor = StateListColor.sample()
    Column {
        StatefulListItem {
            Row(verticalAlignment = Alignment.CenterVertically) {
                StatefulIcon(imageVector = Icons.Filled.Check, contentDescription = null, tint = sampleColor)
                Spacer(modifier = Modifier.width(8.dp))
                StatefulText(text = "Stateful", color = sampleColor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Stateless")
            }
        }
        StatefulListItem(enabled = false) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                StatefulIcon(imageVector = Icons.Filled.Check, contentDescription = null, tint = sampleColor)
                Spacer(modifier = Modifier.width(8.dp))
                StatefulText(text = "Stateful", color = sampleColor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Stateless")
            }
        }
    }
}