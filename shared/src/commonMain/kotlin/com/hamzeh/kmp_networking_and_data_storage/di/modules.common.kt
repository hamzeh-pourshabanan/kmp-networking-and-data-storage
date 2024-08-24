package com.hamzeh.kmp_networking_and_data_storage.di

import com.hamzeh.kmp_networking_and_data_storage.data.db.AppDatabaseConstructor
import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.RoomBuilder
import com.hamzeh.kmp_networking_and_data_storage.data.db.getRoomDatabase
import com.hamzeh.kmp_networking_and_data_storage.data.network.apiClient
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.data.repository.RocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.ktor.KtorSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.room.RoomSpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.DefaultGetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.GetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.DefaultRefreshRocketLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.RefreshRocketLaunchesUseCase
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

private const val BASE_URL = "https://api.spacexdata.com"

val coreModule = module {
    single<HttpClient> { apiClient(BASE_URL) }
    }

val sharedModule = module {
    single<SpaceXRemoteDataSource> { KtorSpaceXRemoteDataSource(get<HttpClient>()) }

    single<Database> { getRoomDatabase(get()) }
    single<SpaceXLocalDataSource> { RoomSpaceXLocalDataSource(get<Database>().getDao()) }
    single<RocketLaunchRepository> { DefaultRocketLaunchRepository(localDataSource = get<SpaceXLocalDataSource>(), remoteDataSource = get())}
    single<GetLaunchesUseCase> { DefaultGetLaunchesUseCase(get<RocketLaunchRepository>())}
    factory<RefreshRocketLaunchesUseCase> { DefaultRefreshRocketLaunchesUseCase(get<RocketLaunchRepository>())}
}

expect val platformModule: Module