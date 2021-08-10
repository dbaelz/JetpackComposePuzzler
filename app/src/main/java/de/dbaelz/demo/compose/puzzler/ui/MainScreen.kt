package de.dbaelz.demo.compose.puzzler.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .fillMaxWidth()
            .verticalScroll(scrollState),
    ) {
        Spacer(Modifier.height(8.dp))

        model.items.forEach {
            when (it) {
                is MainMenuModel.Item.Separator -> {
                    Spacer(Modifier.height(16.dp))
                }
                is MainMenuModel.Item.Entry -> {
                    MenuButton(Modifier.align(Alignment.CenterHorizontally), it, onItemSelected)

                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun MenuButton(
    modifier: Modifier,
    entry: MainMenuModel.Item.Entry,
    onItemSelected: (Screen) -> Unit
) {
    Button(
        modifier = modifier
            .width(220.dp)
            .height(48.dp),
        onClick = { onItemSelected(entry.targetScreen) }
    ) {
        entry.icon?.let {
            Icon(
                it, null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(28.dp)
            )
        }
        Text(entry.name, fontSize = 20.sp)
    }
}
