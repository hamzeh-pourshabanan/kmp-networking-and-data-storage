package com.hamzeh.kmp_networking_and_data_storage.unit.data.resources

import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class InMemorySpaceXLocalDataSource: SpaceXLocalDataSource {

    private val mutex = Mutex()

    private val rocketLaunches = mutableListOf<RocketLaunchEntity>()

    private val _flow = MutableStateFlow(rocketLaunches)
    override fun getAllLaunches(): Flow<List<RocketLaunchEntity>> {
        return _flow
    }

    override suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>): Result<Unit> {
        return runCatching {
            mutex.withLock {
                rocketLaunches.addAll(launches)
                _flow.update { rocketLaunches }
            }
        }
    }
}