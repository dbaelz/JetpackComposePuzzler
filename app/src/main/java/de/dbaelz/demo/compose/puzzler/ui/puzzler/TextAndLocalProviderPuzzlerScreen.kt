package de.dbaelz.demo.compose.puzzler.ui.puzzler

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextAndLocalProviderPuzzlerScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextAndLocalProviderPuzzler()
    }
}

/**
 * Explanation in the tweets: https://twitter.com/dbaelz/status/1423248388255059976
 */
@Composable
private fun TextAndLocalProviderPuzzler() {
    CompositionLocalProvider(
        LocalTextStyle provides TextStyle(color = Color.Magenta),
        LocalContentColor provides Color.Cyan
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides TextStyle(color = Color.Red),
            LocalContentColor provides Color.Blue
        ) {
            Text(text = "Hello Puzzlers!", fontSize = 24.sp)
        }
    }
}