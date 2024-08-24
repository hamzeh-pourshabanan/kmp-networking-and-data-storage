package com.hamzeh.kmp_networking_and_data_storage.integration.di

import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import kotlin.test.AfterTest
import kotlin.test.Test

class CheckModulesTest : KoinTest {

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `validate modules`() {
        startTestKoin(testPlatformModule)
            .checkModules()
    }
}