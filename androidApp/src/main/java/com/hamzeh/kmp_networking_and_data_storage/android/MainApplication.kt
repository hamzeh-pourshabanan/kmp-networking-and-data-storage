package com.hamzeh.kmp_networking_and_data_storage.android

import android.app.Application
import com.hamzeh.kmp_networking_and_data_storage.LibraryInitializer
import com.hamzeh.kmp_networking_and_data_storage.PlatformConfig

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        LibraryInitializer().init(config = PlatformConfig(this))
    }
}