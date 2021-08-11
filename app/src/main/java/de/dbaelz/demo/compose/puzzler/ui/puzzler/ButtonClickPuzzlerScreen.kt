package de.dbaelz.demo.compose.puzzler.ui.puzzler

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonClickPuzzlerScreen() {
    var clickText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ModifierButtonClickPuzzler(onClick = { clickText = it })

        Spacer(Modifier.height(16.dp))

        Text("Click listener: $clickText")
    }
}

/**
 * Explanation in the tweets: https://twitter.com/dbaelz/status/1419976352946692117
 */
@Composable
private fun ModifierButtonClickPuzzler(onClick: (String) -> Unit) {
    Button(onClick = { onClick("One") },
        modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .clickable { onClick("Two") }) {
        Text("Click me!")
    }
}