package dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}