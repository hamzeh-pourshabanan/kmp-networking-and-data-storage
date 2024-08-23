package com.hamzeh.kmp_networking_and_data_storage.di

import com.hamzeh.kmp_networking_and_data_storage.data.db.AppDatabaseConstructor
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.network.apiClient
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.data.repository.RocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.ktor.KtorSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.room.RoomSpaceXLocalDataSource
import io.ktor.client.HttpClient
import org.koin.dsl.module

private const val BASE_URL = "https://api.spacexdata.com"

val coreModule = module {
    single<HttpClient> { apiClient(BASE_URL) }
    single<SpaceXRemoteDataSource> { KtorSpaceXRemoteDataSource(get<HttpClient>()) }

    single<Database> { AppDatabaseConstructor.initialize() }
    single<SpaceXLocalDataSource> { RoomSpaceXLocalDataSource(get()) }
    single<RocketLaunchRepository> { DefaultRocketLaunchRepository(localDataSource = get(), remoteDataSource = get())}
}