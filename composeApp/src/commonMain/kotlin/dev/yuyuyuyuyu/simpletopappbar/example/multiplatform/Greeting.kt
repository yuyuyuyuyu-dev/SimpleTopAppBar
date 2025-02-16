package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}