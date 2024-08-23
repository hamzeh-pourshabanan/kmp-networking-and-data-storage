package com.hamzeh.kmp_networking_and_data_storage.data.repository

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import kotlinx.coroutines.flow.Flow

interface RocketLaunchRepository {
    fun getAllLaunches(): Flow<List<RocketLaunchEntity>>
    suspend fun fetchAllLaunches(): Result<Unit>
}