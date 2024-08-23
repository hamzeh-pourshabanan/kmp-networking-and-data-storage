package com.hamzeh.kmp_networking_and_data_storage

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform