package com.hamzeh.kmp_networking_and_data_storage.unit.data.repository

import app.cash.turbine.test
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.FakeSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.InMemorySpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.StupSpaceXRemoteDataSource
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DefaultRocketLauncherRepositoryTest {

    val localDataSource = InMemorySpaceXLocalDataSource()

    @Test
    fun `when fetch launches then localDataSource should be filled`() = runTest {
        // Given
        val remoteDataSource = FakeSpaceXRemoteDataSource()
        val repository = DefaultRocketLaunchRepository(
            localDataSource,
            remoteDataSource
        )

        // When
        repository.fetchAllLaunches()

        // Then
        localDataSource.getAllLaunches().test {
            assertEquals(true, awaitItem().isNotEmpty())
        }

        repository.getAllLaunches().test {
            assertEquals(true, awaitItem().isNotEmpty())
        }
    }

    @Test
    fun `when remote response is empty then local data source is empty`() = runTest {
        // Given
        val remoteDataSource = StupSpaceXRemoteDataSource("emptyResult.json")
        val repository = DefaultRocketLaunchRepository(
            localDataSource,
            remoteDataSource
        )

        // When
        repository.fetchAllLaunches()

        // Then
        localDataSource.getAllLaunches().test {
            assertEquals(true, awaitItem().isEmpty())
        }
        repository.getAllLaunches().test {
            assertEquals(true, awaitItem().isEmpty())
        }
    }

    @Test
    fun `when remote response missing fields then fetch response should fail`() = runTest {
        // Given
        val remoteDataSource = StupSpaceXRemoteDataSource("missingFieldsLaunches.json")
        val repository = DefaultRocketLaunchRepository(
            localDataSource,
            remoteDataSource
        )

        // When
        val result = repository.fetchAllLaunches()

        // Then
        assertEquals(true, result.isFailure)

    }
}