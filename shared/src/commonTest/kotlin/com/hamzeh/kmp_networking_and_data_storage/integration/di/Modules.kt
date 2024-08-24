package com.hamzeh.kmp_networking_and_data_storage.integration.di

import com.hamzeh.kmp_networking_and_data_storage.integration.data.network.MockClient
import com.hamzeh.kmp_networking_and_data_storage.integration.data.network.testKtorClient
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val testPlatformModule: Module = module {
    single<MockClient> { MockClient() }
    single<HttpClient> { testKtorClient(get()) }
}