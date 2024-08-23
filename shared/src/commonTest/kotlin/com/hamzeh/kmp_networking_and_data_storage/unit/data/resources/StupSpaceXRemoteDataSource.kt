package com.hamzeh.kmp_networking_and_data_storage.unit.data.resources

import com.hamzeh.kmp_networking_and_data_storage.JsonLoader
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource

class StupSpaceXRemoteDataSource(
    private val rocketLaunchesResource: String = ""
): SpaceXRemoteDataSource {
    override suspend fun getAllLaunches(): Result<List<RocketLaunch>> {
        return runCatching {
            JsonLoader.load<List<RocketLaunch>>(rocketLaunchesResource)
        }
    }
}