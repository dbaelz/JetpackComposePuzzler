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

// TODO: Add real description texts
fun createMainMenuModel(): MainMenuModel {
    return MainMenuModel(
        listOf(
            MainMenuModel.Item.Entry(
                name = "Modifier Border",
                description = "This is a puzzler about borders ;)",
                targetScreen = Screen.MODIFIER_BORDER
            ),
            MainMenuModel.Item.Entry(
                name = "Simplified Modifier Border",
                description = "A simplified version with borders. A simplified version with borders. " +
                        "A simplified version with borders. A simplified version with borders." +
                        "A simplified version with borders. A simplified version with borders.",
                targetScreen = Screen.MODIFIER_BORDER_SIMPLIFIED
            ),

            MainMenuModel.Item.Separator,

            MainMenuModel.Item.Entry(
                name = "Modifier Click",
                description = "Multiple click listener registered with the modifier. What's happening?",
                targetScreen = Screen.MODIFIER_CLICK
            ),
            MainMenuModel.Item.Entry(
                name = "Button Click",
                description = "Button click listener puzzler",
                targetScreen = Screen.BUTTON_CLICK
            ),

            MainMenuModel.Item.Separator,

            MainMenuModel.Item.Entry(
                name = "Text color with LocalProvider",
                description = "The text color is set with the LocalProvider. Multiple times...",
                targetScreen = Screen.TEXT_LOCAL_PROVIDER
            ),
        )
    )
}