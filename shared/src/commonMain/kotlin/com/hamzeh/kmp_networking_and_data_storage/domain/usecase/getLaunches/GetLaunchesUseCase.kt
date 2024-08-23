package com.hamzeh.kmp_networking_and_data_storage.domain.usecase.getLaunches

import com.hamzeh.kmp_networking_and_data_storage.data.repository.RocketLaunchRepository
import com.hamzeh.kmp_networking_and_data_storage.domain.mapper.toDomainModel
import com.hamzeh.kmp_networking_and_data_storage.domain.model.RocketLaunchDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface GetLaunchesUseCase {
    operator fun invoke(): Flow<List<RocketLaunchDomainModel>>
}

class DefaultGetLaunchesUseCase(
    private val repository: RocketLaunchRepository
): GetLaunchesUseCase {
    override fun invoke(): Flow<List<RocketLaunchDomainModel>> {
        return repository.getAllLaunches().map { it.toDomainModel() }
    }
}