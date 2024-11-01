package com.hamzeh.kmp_networking_and_data_storage.integration.domain

import app.cash.turbine.test
import com.hamzeh.kmp_networking_and_data_storage.JsonLoader
import com.hamzeh.kmp_networking_and_data_storage.data.repository.DefaultRocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.data.sources.ktor.KtorSpaceXRemoteDataSource
import com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches.DefaultRefreshRocketLaunchesUseCase
import com.hamzeh.kmp_networking_and_data_storage.integration.data.network.MockClient
import com.hamzeh.kmp_networking_and_data_storage.integration.data.network.MockResponse
import com.hamzeh.kmp_networking_and_data_storage.integration.data.network.testKtorClient
import com.hamzeh.kmp_networking_and_data_storage.unit.data.resources.InMemorySpaceXLocalDataSource
import kotlinx.coroutines.test.runTest
import org.koin.test.KoinTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RefreshRocketLaunchesUseCaseIntegrationTest: KoinTest {

    private val jsonResponse = JsonLoader.load("launches.json")

    //KtorClient setup
    private val mockClient = MockClient()
    private val ktorClient = testKtorClient(mockClient)
    private val networkDataSource = KtorSpaceXRemoteDataSource(ktorClient)
    private val localDataSource =InMemorySpaceXLocalDataSource()
    private val repository = DefaultRocketLaunchRepository(localDataSource, networkDataSource)

    private  val refreshRocketLaunchesUseCase = DefaultRefreshRocketLaunchesUseCase(repository)



        @Test
    fun `When I call refresh update the local storage`() = runTest {
        //Given
        val response = MockResponse.ok(jsonResponse)
        mockClient.setResponse(response)
        //When
            refreshRocketLaunchesUseCase.invoke()
        //Then
        localDataSource.getAllLaunches().test {
            assertEquals(true, awaitItem().isNotEmpty())
        }
    }
}