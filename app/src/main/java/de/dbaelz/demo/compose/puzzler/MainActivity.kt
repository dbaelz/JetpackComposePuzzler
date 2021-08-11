package de.dbaelz.demo.compose.puzzler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.dbaelz.demo.compose.puzzler.Screen.ABOUT
import de.dbaelz.demo.compose.puzzler.Screen.MAIN
import de.dbaelz.demo.compose.puzzler.data.createMainMenuModel
import de.dbaelz.demo.compose.puzzler.ui.AboutScreen
import de.dbaelz.demo.compose.puzzler.ui.MainScreen
import de.dbaelz.demo.compose.puzzler.ui.theme.JetpackComposePuzzlerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePuzzlerTheme {
                val navController = rememberNavController()
                val backstackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    topBar = { TopBar("Jetpack Compose Puzzler") },
                ) {
                    PuzzlerNavHost(navController, Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
private fun TopBar(title: String) {
    TopAppBar(title = { Text(title) })
}

@Composable
private fun PuzzlerNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MAIN.name,
        modifier = modifier
    ) {
        composable(MAIN.name) {
            MainScreen(createMainMenuModel()) { navController.navigate(it.name) }
        }

        composable(ABOUT.name) {
            AboutScreen()
        }
    }
}

enum class Screen {
    MAIN,
    ABOUT,
    MODIFIER_BORDER,
    MODIFIER_BORDER_SIMPLIFIED,
    MODIFIER_CLICK,
    BUTTON_CLICK,
    TEXT_LOCAL_PROVIDER,
}