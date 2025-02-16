package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MultiplatformExample",
    ) {
        App()
    }
}