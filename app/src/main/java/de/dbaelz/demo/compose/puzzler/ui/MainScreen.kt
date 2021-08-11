package de.dbaelz.demo.compose.puzzler.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dbaelz.demo.compose.puzzler.Screen
import de.dbaelz.demo.compose.puzzler.data.MainMenuModel

@Composable
fun MainScreen(model: MainMenuModel, onItemSelected: (Screen) -> Unit) {
    val scrollState = rememberScrollState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(Modifier.height(8.dp))

        model.items.forEach { item ->
            when (item) {
                is MainMenuModel.Item.Separator -> {
                    Separator()
                }
                is MainMenuModel.Item.Entry -> {
                    MenuCard(item, onItemSelected)
                }
            }
        }
    }
}

@Composable
private fun Separator() {
    Spacer(Modifier.height(8.dp))

    Divider(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primaryVariant,
        thickness = 8.dp
    )

    Spacer(Modifier.height(8.dp))
}

@Composable
private fun MenuCard(entry: MainMenuModel.Item.Entry, onItemSelected: (Screen) -> Unit) {
    Card(
        elevation = 12.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(148.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .clickable {
                onItemSelected(entry.route)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = entry.name,
                color = MaterialTheme.colors.primary,
                fontSize = 20.sp
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = entry.description,
                fontSize = 16.sp
            )
        }
    }
}
