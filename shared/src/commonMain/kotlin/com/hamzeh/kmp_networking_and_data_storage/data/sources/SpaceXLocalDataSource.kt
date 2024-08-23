package com.hamzeh.kmp_networking_and_data_storage.data.sources

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch

interface SpaceXLocalDataSource {
    suspend fun getAllLaunches(): Result<List<RocketLaunchEntity>>
    suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>): Result<Unit>
}