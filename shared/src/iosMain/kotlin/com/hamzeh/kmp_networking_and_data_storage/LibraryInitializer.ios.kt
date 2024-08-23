package com.hamzeh.kmp_networking_and_data_storage

import com.hamzeh.kmp_networking_and_data_storage.di.startKoinApplication

actual fun providePlatformInitializer(): PlatformInitializer {
    return object : PlatformInitializer {
        override fun init(config: PlatformConfig) {
            startKoinApplication()
        }
    }
}

actual class PlatformConfig