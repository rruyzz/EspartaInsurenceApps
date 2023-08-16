package com.esparta.espartainsurence

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform