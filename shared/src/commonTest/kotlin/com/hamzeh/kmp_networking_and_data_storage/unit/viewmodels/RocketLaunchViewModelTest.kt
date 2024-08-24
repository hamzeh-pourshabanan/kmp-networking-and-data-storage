package com.hamzeh.kmp_networking_and_data_storage.unit.viewmodels

import app.cash.turbine.test
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches.DefaultGetLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.DefaultRefreshRocketLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.domain.viewmodels.RocketLaunchViewModel
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.FakeSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.InMemorySpaceXLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class RocketLaunchViewModelTest {
    private val remoteDataSource = FakeSpaceXRemoteDataSource()
    private val localDataSource = InMemorySpaceXLocalDataSource()
    private val repository = DefaultRocketLaunchRepository(localDataSource, remoteDataSource)
    private val getLaunchesUseCase = DefaultGetLaunchesUseCase(repository)
    private val refreshRocketLaunchesUseCase = DefaultRefreshRocketLaunchesUseCase(repository)

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when initialize viewmodel launches are fetched`() = runTest {
        // When
        val viewModel = RocketLaunchViewModel(
            getLaunchesUseCase,
            refreshRocketLaunchesUseCase
        )
        // Then
        viewModel.rocketLaunchesUiState.test {
            assertEquals(true, awaitItem().isNotEmpty())

        }
    }
}