package com.hamzeh.kmp_networking_and_data_storage.data.sources.ktor

import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import com.hamzeh.kmp_networking_and_data_storage.data.network.apiClient
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXRemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorSpaceXRemoteDataSource(
    private val httpClient: HttpClient
): SpaceXRemoteDataSource {
    override suspend fun getAllLaunches(): Result<List<RocketLaunch>> {
        return runCatching {
            httpClient.get("/v5/launches").body<List<RocketLaunch>>()
        }
    }
}