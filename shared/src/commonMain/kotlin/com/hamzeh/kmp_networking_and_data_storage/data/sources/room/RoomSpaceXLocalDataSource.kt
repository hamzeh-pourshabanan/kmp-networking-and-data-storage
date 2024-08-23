package com.hamzeh.kmp_networking_and_data_storage.data.sources.room

import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.dao.SpaceXDao
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import com.hamzeh.kmp_networking_and_data_storage.data.dto.RocketLaunch
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class RoomSpaceXLocalDataSource(
    private val db: Database,
): SpaceXLocalDataSource {

    private val dao: SpaceXDao = db.getDao()

    override suspend fun getAllLaunches(): Result<List<RocketLaunch>> {
        return runCatching {
            dao.getAllLaunches()
        }
    }

    override suspend fun insertAllLaunches(launches: List<RocketLaunch>): Result<Unit> {
        return runCatching {
            dao.insertAllLaunches(launches)
        }
    }


}