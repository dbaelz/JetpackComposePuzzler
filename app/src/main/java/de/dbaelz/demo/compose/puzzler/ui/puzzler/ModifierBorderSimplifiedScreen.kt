package de.dbaelz.demo.compose.puzzler.ui.puzzler

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ModifierBorderSimplifiedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ModifierBorderSimplified()
    }
}

/**
 * Explanation in the tweets: https://twitter.com/dbaelz/status/1418498803456434178
 */
@Composable
private fun ModifierBorderSimplified(borderWidth: Dp = 12.dp) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .border(borderWidth, Color.Gray)
            .offset(4.dp, 4.dp)
            .border(borderWidth, Color.Cyan)
    )
}