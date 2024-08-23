package com.hamzeh.kmp_networking_and_data_storage.demo

import java.io.InputStream
fun interface DemoAssetManager {
    fun open(fileName: String): InputStream
}