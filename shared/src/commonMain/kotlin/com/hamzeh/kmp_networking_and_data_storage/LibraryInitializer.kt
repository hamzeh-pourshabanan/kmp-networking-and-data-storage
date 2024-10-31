package com.hamzeh.kmp_networking_and_data_storage

class LibraryInitializer {

    private val platformInitializer = providePlatformInitializer()

    fun init(config: PlatformConfig) {
        platformInitializer.init(config)
    }
}

interface PlatformInitializer {
    fun init(config: PlatformConfig)
}


expect fun providePlatformInitializer(): PlatformInitializer
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class PlatformConfig