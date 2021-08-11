package de.dbaelz.demo.compose.puzzler.ui.puzzler

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalFoundationApi
@Composable
fun ModifierClickPuzzlerScreen() {
    var clickText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ModifierClickPuzzler(onClick = { clickText = it })

        Spacer(Modifier.height(16.dp))

        Text("Click listener: $clickText")
    }
}

/**
 * Explanation in the tweets: https://twitter.com/dbaelz/status/1419976352946692117
 */
@ExperimentalFoundationApi
@Composable
private fun ModifierClickPuzzler(onClick: (String) -> Unit) {
    ClickableText(
        modifier = Modifier
            .clickable { onClick("One") }
            .combinedClickable(onClick = { onClick("two") }),
        onClick = onClick
    )
}

@ExperimentalFoundationApi
@Composable
private fun ClickableText(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
) {
    Box(modifier = modifier
        .size(100.dp)
        .background(MaterialTheme.colors.primary)
        .clickable { onClick("Three") }
        .combinedClickable(onClick = { onClick("Four") }),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Click me!",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary,
            fontSize = 20.sp,
            modifier = modifier
                .fillMaxSize()
                .clickable { onClick("Five") }
                .combinedClickable(onClick = { onClick("Six") })
        )
    }
}