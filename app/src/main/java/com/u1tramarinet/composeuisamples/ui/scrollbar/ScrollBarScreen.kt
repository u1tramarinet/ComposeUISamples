package com.u1tramarinet.composeuisamples.ui.scrollbar

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollBarScreen() {
    val list = (1..100).toList()
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.fillMaxSize()) {
        ScrollBar(modifier = Modifier.weight(0.2f), scrollState = scrollState)
        Column(
            modifier = Modifier
                .weight(0.8f)
                .verticalScroll(state = scrollState)
        ) {
            list.forEach {
                ListItem(index = it)
            }
        }
    }
}

@Composable
private fun ListItem(index: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "id=$index")
    }
}

@Composable
private fun ScrollBar(modifier: Modifier = Modifier, scrollState: ScrollState) {
    LaunchedEffect(scrollState.isScrollInProgress) {
        Log.d("ScrollBar", "isScrollInProgress=${scrollState.isScrollInProgress}")
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp)
    ) {
        IconButton(onClick = { }, modifier = Modifier.weight(0.1f)) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowUp,
                contentDescription = "",
            )
        }
        ScrollThumb(
            modifier = Modifier
                .weight(0.8f)
                .padding(4.dp),
            scrollState = scrollState,
        )
        IconButton(onClick = { }, modifier = Modifier.weight(0.1f)) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "",
            )
        }
    }
}

@Composable
private fun ScrollThumb(modifier: Modifier = Modifier, scrollState: ScrollState) {
    val totalDistance = scrollState.maxValue.toFloat()
}