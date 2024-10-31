package com.hamzeh.kmp_networking_and_data_storage

import android.content.Context
import com.hamzeh.kmp_networking_and_data_storage.di.startKoinApplication
import org.koin.dsl.module

actual class PlatformConfig(val context: Context)

actual fun providePlatformInitializer(): PlatformInitializer {
    return object : PlatformInitializer {
        override fun init(config: PlatformConfig) {
            startKoinApplication(
                module {
                    single<PlatformConfig> { config }
                }
            )
        }
    }
}
