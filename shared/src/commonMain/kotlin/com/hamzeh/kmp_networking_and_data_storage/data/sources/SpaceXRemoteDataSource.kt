package com.hamzeh.kmp_networking_and_data_storage.data.sources

import com.hamzeh.kmp_networking_and_data_storage.entity.RocketLaunch

interface SpaceXRemoteDataSource {
    suspend fun getAllLaunches(): Result<List<RocketLaunch>>
}