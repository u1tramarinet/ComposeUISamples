package com.u1tramarinet.composeuisamples.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun StatefulText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    style: TextStyle = LocalTextStyle.current,
    color: StateListColor = StateListColor(MaterialTheme.colorScheme.surface),
    state: WidgetState = LocalWidgetState.current,
) {
    val mergedColor = color.getFrom(state)
    Text(
        text = text,
        modifier = modifier,
        color = mergedColor,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = style,
    )
}

@Composable
@Preview
fun StatefulTextPreview() {
    val sampleColor = StateListColor.sample()
    Column {
        StatefulText(text = "Hello")
        StatefulText(
            text = "Hello(color)",
            color = sampleColor,
        )
        StatefulText(
            text = "Hello(disabled)",
            state = WidgetState(enabled = false),
            color = sampleColor,
        )
        StatefulText(
            text = "Hello(selected)",
            state = WidgetState(selected = true),
            color = sampleColor,
        )
        StatefulText(
            text = "Hello(checked)",
            state = WidgetState(checked = true),
            color = sampleColor,
        )
        StatefulText(
            text = "Hello(pressed)",
            state = WidgetState(pressed = true),
            color = sampleColor,
        )
    }
}