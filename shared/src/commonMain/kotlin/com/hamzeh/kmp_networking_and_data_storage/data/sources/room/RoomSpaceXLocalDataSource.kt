package com.hamzeh.kmp_networking_and_data_storage.data.sources.room

import com.hamzeh.kmp_networking_and_data_storage.data.db.Database
import com.hamzeh.kmp_networking_and_data_storage.data.db.dao.SpaceXDao
import com.hamzeh.kmp_networking_and_data_storage.data.db.entity.RocketLaunchEntity
import com.hamzeh.kmp_networking_and_data_storage.data.sources.SpaceXLocalDataSource
import kotlinx.coroutines.flow.Flow

class RoomSpaceXLocalDataSource(
    db: Database,
): SpaceXLocalDataSource {

    private val dao: SpaceXDao = db.getDao()

    override fun getAllLaunches(): Flow<List<RocketLaunchEntity>> {
        return dao.getAllLaunches()
    }

    override suspend fun insertAllLaunches(launches: List<RocketLaunchEntity>): Result<Unit> {
        return runCatching {
            dao.insertAllLaunches(launches)
        }
    }


}