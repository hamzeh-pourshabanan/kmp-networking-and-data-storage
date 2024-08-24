package com.hamzeh.kmp_networking_and_data_storage.integration.di

import com.hamzeh.kmp_networking_and_data_storage.di.sharedModule
import com.hamzeh.kmp_networking_and_data_storage.di.startKoinApplication
import org.koin.core.KoinApplication
import org.koin.core.context.stopKoin
import org.koin.core.module.Module


fun startTestKoin(testModule: Module): KoinApplication {
    return startKoinApplication(listOf(testModule, sharedModule))
}

fun stopTestKoin() {
    stopKoin()
}