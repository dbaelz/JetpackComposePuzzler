package de.dbaelz.demo.compose.puzzler.ui.puzzler

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ModifierBorderPuzzlerScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ModifierBorderPuzzler()
    }
}

/**
 * Explanation in the tweets: https://twitter.com/dbaelz/status/1418134001232056320
 */
@Composable
private fun ModifierBorderPuzzler(borderWidth: Dp = 12.dp) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .border(borderWidth, Color.Gray)
            .border(borderWidth, Color.Cyan)

            .padding(borderWidth)

            .border(borderWidth, Color.Blue)
            .border(borderWidth, Color.Magenta)

            .padding(borderWidth)

            .border(borderWidth, Color.Yellow)
            .border(borderWidth, Color.Black)

            .padding(borderWidth)
    )
}