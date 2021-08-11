package de.dbaelz.demo.compose.puzzler.data

import de.dbaelz.demo.compose.puzzler.Screen

data class MainMenuModel(val items: List<Item> = emptyList()) {
    sealed class Item {
        object Separator : Item()
        data class Entry(
            val name: String,
            val description: String = "",
            val route: Screen,
        ) : Item()
    }
}

fun createMainMenuModel(): MainMenuModel {
    return MainMenuModel(
        listOf(
            MainMenuModel.Item.Entry(
                name = "Modifier Border",
                description = "What happens when several borders are defined that would overlap each other?",
                route = Screen.MODIFIER_BORDER
            ),
            MainMenuModel.Item.Entry(
                name = "Simplified Modifier Border",
                description = "Simplified version of the Modifier Border puzzler that shows the usage to create visual effects.",
                route = Screen.MODIFIER_BORDER_SIMPLIFIED
            ),

            MainMenuModel.Item.Separator,

            MainMenuModel.Item.Entry(
                name = "Modifier Click",
                description = "Multiple click listener are registered for a composable. Which one is called?",
                route = Screen.MODIFIER_CLICK
            ),
            MainMenuModel.Item.Entry(
                name = "Button Click",
                description = "Similar to the Modifier Click, but for a button with onClick parameter and Modifier.",
                route = Screen.BUTTON_CLICK
            ),

            MainMenuModel.Item.Separator,

            MainMenuModel.Item.Entry(
                name = "Text color and LocalProvider",
                description = "Two CompositionLocalProvider in combination with a Text. Both set multiple text color values. Which one is used?",
                route = Screen.TEXT_LOCAL_PROVIDER
            ),
        )
    )
}