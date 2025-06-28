package dev.yuyuyuyuyu.simpleTopAppBar.example.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform