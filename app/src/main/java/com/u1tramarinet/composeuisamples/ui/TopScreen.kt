package com.u1tramarinet.composeuisamples.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopScreen(
    onItemClick: (route: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Item(route = ComposeUISamplesRoute.SCROLL_BAR, onClick = onItemClick)
    }
}

@Composable
private fun Item(route: String, onClick: (String) -> Unit) {
    Button(onClick = { onClick(route) }, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Go to $route")
    }
}