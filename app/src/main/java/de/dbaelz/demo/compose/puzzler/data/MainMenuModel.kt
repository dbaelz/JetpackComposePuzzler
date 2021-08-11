package de.dbaelz.demo.compose.puzzler.data

import de.dbaelz.demo.compose.puzzler.Screen

data class MainMenuModel(val items: List<Item> = emptyList()) {
    sealed class Item {
        object Separator : Item()
        data class Entry(
            val name: String,
            val description: String = "",
            val targetScreen: Screen,
        ) : Item()
    }
}

// TODO: Add real entries
fun createMainMenuModel(): MainMenuModel {
    return MainMenuModel(
        listOf(
            MainMenuModel.Item.Entry(
                name = "Modifier Border Puzzler",
                description = "This is a puzzler about borders ;)",
                targetScreen = Screen.ABOUT
            ),
            MainMenuModel.Item.Entry(
                name = "Simplified Modifier Border Puzzler",
                description = "A simplified version with borders. A simplified version with borders. " +
                        "A simplified version with borders. A simplified version with borders." +
                        "A simplified version with borders. A simplified version with borders.",
                targetScreen = Screen.ABOUT
            ),

            MainMenuModel.Item.Separator,

            MainMenuModel.Item.Entry(
                name = "Modifier Click Puzzler",
                description = "Multiple click listener registered with the modifier. What's happening?",
                targetScreen = Screen.ABOUT
            ),
            MainMenuModel.Item.Entry(
                name = "Modifier Click Puzzler",
                description = "Multiple click listener registered with the modifier. What's happening?",
                targetScreen = Screen.ABOUT
            ),
        )
    )
}