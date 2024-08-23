package com.hamzeh.kmp_networking_and_data_storage.domain.usecase.refreshLaunches

import com.hamzeh.kmp_networking_and_data_storage.data.repository.RocketLaunchRepository

interface RefreshRocketLaunchesUseCase {
    suspend operator fun invoke(): Result<Unit>

}
class RefreshRocketLaunches(
    private val repository: RocketLaunchRepository
): RefreshRocketLaunchesUseCase {
    override suspend fun invoke(): Result<Unit> {
        return repository.fetchAllLaunches()
    }
}