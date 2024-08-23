package com.hamzeh.kmp_networking_and_data_storage.data.sources.room

import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.dao.SpaceXDao
import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource

class RoomSpaceXLocalDataSource(
    db: Database,
): SpaceXLocalDataSource {

    private val dao: SpaceXDao = db.getDao()

    override suspend fun getAllLaunches(): Result<List<RocketLaunchEntity>> {
        return runCatching {
            dao.getAllLaunches()
        }
    }

    override suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>): Result<Unit> {
        return runCatching {
            dao.insertAllLaunches(launches)
        }
    }


}