package dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform

class JsPlatform : Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = JsPlatform()
