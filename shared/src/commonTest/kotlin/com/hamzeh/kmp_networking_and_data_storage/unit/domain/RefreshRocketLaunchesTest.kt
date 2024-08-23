package com.hamzeh.kmp_networking_and_data_storage.unit.domain

import app.cash.turbine.test
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.RefreshRocketLaunches
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.FakeSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.InMemorySpaceXLocalDataSource
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RefreshRocketLaunchesTest {
    val remoteDataSource = FakeSpaceXRemoteDataSource()
    val localXLocalDataSource = InMemorySpaceXLocalDataSource()
    val repository = DefaultRocketLaunchRepository(
        remoteDataSource = remoteDataSource,
        localDataSource = localXLocalDataSource
    )

    @Test
    fun `When refresh launches then data source is populated by remote data`() = runTest{
        RefreshRocketLaunches(repository).invoke()

        localXLocalDataSource.getAllLaunches().test {
            assertEquals(true, awaitItem().isNotEmpty())
        }
    }
}