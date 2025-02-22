# SimpleTopAppBar
A simple TopAppBar for Android and Compose Multiplatrorm, include navigate back button and kebab menu button.

## Installation
### Android
app/build.gradle.kts
```diff
dependencies {
    ...

+   implementation("dev.yuyuyuyuyu:simpletopappbar:0.1.0")
}
```

### Compose Multiplatform
composeApp/build.gradle.kts
```diff
kotlin {
...

    sourceSets {
        ...

        commonMain.dependencies {
            ...

+           implementation("dev.yuyuyuyuyu:simpletopappbar:0.1.0")
        }
    }
}

```

## Screenshots
### Android
<img width="300" alt="Android main screen screenshot" src="https://github.com/user-attachments/assets/11416c50-febf-43e7-8287-1aa01c68ba53" />
<img width="300" alt="Android open source licenses screen screenshot" src="https://github.com/user-attachments/assets/5ca8ac16-29a3-4303-bf37-54ca62962e64" />


### Compose Multiplatform
<img width="300" alt="Compose Multiplatform main screen screenshot" src="https://github.com/user-attachments/assets/61259d40-ddd5-42b8-b35a-a084724882b7" />
<img width="300" alt="Compose Multiplatform open source licenses screen screenshot" src="https://github.com/user-attachments/assets/38be0a16-8af3-4632-b299-a98e23ffcd21" />

## Examples
### Android
[app/src/main/java/dev/yuyuyuyuyu/simpletopappbar/example/android/ui/App.kt](https://github.com/yu-ko-ba/SimpleTopAppBar/blob/main/app/src/main/java/dev/yuyuyuyuyu/simpletopappbar/example/android/ui/App.kt)
```kotlin
@Composable
fun App(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NavigateDestination.valueOf(
        value = backStackEntry?.destination?.route
            ?: NavigateDestination.SimpleTopAppBarExample.name,
    )

    SimpleTopAppBarTheme {
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
```

### Compose Multiplatform
[composeApp/src/commonMain/kotlin/dev/yuyuyuyuyu/simpletopappbar/example/multiplatform/ui/App.kt](https://github.com/yu-ko-ba/SimpleTopAppBar/blob/main/composeApp/src/commonMain/kotlin/dev/yuyuyuyuyu/simpletopappbar/example/multiplatform/ui/App.kt)
```kotlin
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
```

## License
Apache License 2.0
```
Copyright 2025 yu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
