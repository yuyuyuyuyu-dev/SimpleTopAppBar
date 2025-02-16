package dev.yuyuyuyuyu.simpletopappbar

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SimpleTopAppBar",
    ) {
        App()
    }
}