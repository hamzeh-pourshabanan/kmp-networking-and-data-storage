package com.hamzeh.kmp_networking_and_data_storage.data.repository

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.domain.mapper.toEntity
import kotlinx.coroutines.flow.Flow

class DefaultRocketLaunchRepository(
    private val localDataSource: SpaceXLocalDataSource,
    private val remoteDataSource: SpaceXRemoteDataSource
): RocketLaunchRepository {

    override fun getAllLaunches(): Flow<List<RocketLaunchEntity>> {
        return localDataSource.getAllLaunches()
    }

    override suspend fun fetchAllLaunches(): Result<Unit> {
        return remoteDataSource.getAllLaunches().fold(onSuccess = {
            localDataSource.insertAllLaunches(it.toEntity())
            Result.success(Unit)
        }, onFailure = {
            Result.failure(it)
        })
    }
}