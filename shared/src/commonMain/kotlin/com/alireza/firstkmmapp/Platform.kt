package com.alireza.firstkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform