package dev.yuyuyuyuyu.simpletopappbar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
