package com.lucasprioste.handlingdeeplink

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform