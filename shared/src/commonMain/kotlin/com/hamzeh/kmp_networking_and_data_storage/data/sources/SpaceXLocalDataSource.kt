package com.hamzeh.kmp_networking_and_data_storage.data.sources

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import kotlinx.coroutines.flow.Flow

interface SpaceXLocalDataSource {
    fun getAllLaunches(): Flow<List<RocketLaunchEntity>>
    suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>): Result<Unit>
}