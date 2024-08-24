package com.hamzeh.kmp_networking_and_data_storage.unit.domain

import app.cash.turbine.test
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.DefaultGetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.DefaultRefreshRocketLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.FakeSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.InMemorySpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.StupSpaceXRemoteDataSource
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetLaunchesUseCaseTest {
    private val remoteDataSource = FakeSpaceXRemoteDataSource()
    private val localDataSource = InMemorySpaceXLocalDataSource()
    private val repository = DefaultRocketLaunchRepository(localDataSource, remoteDataSource)
    private val getLaunchesUseCase = DefaultGetLaunchesUseCase(repository)
    private val refreshUseCase = DefaultRefreshRocketLaunchesUseCase(repository)

    @Test
    fun `when RefreshUseCased has not been called then GetLaunchesUseCase returns empty`() = runTest{
        getLaunchesUseCase.invoke().test {
            assertEquals(true, awaitItem().isEmpty())
        }
    }

    @Test
    fun `when RefreshUseCased has been called then GetLaunchesUseCase is not empty`() = runTest{
        refreshUseCase.invoke()
        getLaunchesUseCase.invoke().test {
            assertEquals(true, awaitItem().isNotEmpty())
        }
    }

    @Test
    fun `when remote response is incorrect then GetLaunchUseCase returns empty`() = runTest {
        val remote = StupSpaceXRemoteDataSource("missingFieldsLaunches.json")
        val repository = DefaultRocketLaunchRepository(localDataSource, remote)
        val getLaunchesUseCase = DefaultGetLaunchesUseCase(repository)
        val refreshUseCase = DefaultRefreshRocketLaunchesUseCase(repository)
        refreshUseCase.invoke()
        getLaunchesUseCase.invoke().test {
            assertEquals(true, awaitItem().isEmpty())
        }
    }
}