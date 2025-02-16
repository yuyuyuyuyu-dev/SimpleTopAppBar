package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform