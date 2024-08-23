package com.hamzeh.kmp_networking_and_data_storage.unit.data.resources

import com.hamzeh.kmp_networking_and_data_storage.JsonLoader
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource

class FakeSpaceXRemoteDataSource: SpaceXRemoteDataSource {
    private val jsonLoader = JsonLoader

    override suspend fun getAllLaunches(): Result<List<RocketLaunch>> {
        return runCatching {
            jsonLoader.load<List<RocketLaunch>>("launches.json")
        }
    }
}