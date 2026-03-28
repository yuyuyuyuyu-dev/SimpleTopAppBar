package dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform.ui.App
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        ComposeViewport(document.body!!) {
            App()
        }
    }
}
