package dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.yuyuyuyuyu.simpleTopAppBar.SimpleTopAppBar
import dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform.ui.opensourcelicenses.screens.OpenSourceLicensesScreen
import dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform.ui.simpletopappbarexample.screens.SimpleTopAppBarExampleScreen

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NavigateDestination.valueOf(
        value = backStackEntry?.destination?.route
            ?: NavigateDestination.SimpleTopAppBarExample.name,
    )

    val uriHandler = LocalUriHandler.current

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
                    onSourceCodeButtonClick = {
                        uriHandler.openUri("https://github.com/yuyuyuyuyu-dev/SimpleTopAppBar")
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
