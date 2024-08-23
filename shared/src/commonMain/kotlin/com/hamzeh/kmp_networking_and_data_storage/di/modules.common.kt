package com.hamzeh.kmp_networking_and_data_storage.di

import com.hamzeh.kmp_networking_and_data_storage.data.network.apiClient
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.ktor.KtorSpaceXRemoteDataSource
import io.ktor.client.HttpClient
import org.koin.dsl.module

private const val BASE_URL = "https://api.spacexdata.com"

val coreModule = module {
    single<HttpClient> { apiClient(BASE_URL) }
    single<SpaceXRemoteDataSource> { KtorSpaceXRemoteDataSource(get<HttpClient>()) }
}