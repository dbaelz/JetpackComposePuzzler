package de.dbaelz.demo.compose.puzzler.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import de.dbaelz.demo.compose.puzzler.Screen

data class MainMenuModel(val items: List<Item> = emptyList()) {
    sealed class Item {
        object Separator : Item()
        data class Entry(
            val name: String,
            val icon: ImageVector? = null,
            val targetScreen: Screen,
        ) : Item()
    }
}

fun createMainMenuModel(): MainMenuModel {
    return MainMenuModel(
        listOf(
            MainMenuModel.Item.Entry(
                name = "About",
                icon = Icons.Default.Info,
                targetScreen = Screen.ABOUT
            ),
        )
    )
}