package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.yuyuyuyuyu.simpletopappbar.SimpleTopAppBar
import dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui.opensourcelicenses.screens.OpenSourceLicensesScreen
import dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui.simpletopappbarexample.screens.SimpleTopAppBarExampleScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NavigateDestination.valueOf(
        value = backStackEntry?.destination?.route
            ?: NavigateDestination.SimpleTopAppBarExample.name,
    )

    MaterialTheme {
        Scaffold(
            topBar = {
                SimpleTopAppBar(
                    title = currentScreen.name,
                    navigateBackIsPossible = navController.previousBackStackEntry != null,
                    onNavigateBackButtonClick = { navController.navigateUp() },
                    onOpenSourceLicensesButtonClick = {
                        if (currentScreen != NavigateDestination.OpenSourceLicenses) {
                            navController.navigate(NavigateDestination.OpenSourceLicenses.name)
                        }
                    },
                )
            },
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavigateDestination.SimpleTopAppBarExample.name,
                modifier = Modifier.padding(innerPadding),
            ) {
                composable(route = NavigateDestination.SimpleTopAppBarExample.name) {
                    SimpleTopAppBarExampleScreen()
                }
                composable(route = NavigateDestination.OpenSourceLicenses.name) {
                    OpenSourceLicensesScreen()
                }
            }
        }
    }
}
